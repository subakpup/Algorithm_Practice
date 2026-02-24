import java.util.*;
import java.io.*;

public class Main_4386 {
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		double weight;
		
		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo (Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	
	static int n;
	static int[] p, s;
	static double[] xs, ys;
	
	private static void make() {
		p = new int[n];
		s = new int[n];
		
		for (int i = 0; i < n; i++) {
			p[i] = i;
			s[i] = 1;
		}
	}
	
	private static int find(int x) {
		while (p[x] != x) {
			p[x] = p[p[x]];
			x = p[x];
		}
		return x;
	}
	
	private static boolean union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		
		if (ra == rb) return false;
		
		if (s[ra] < s[rb]) {
			int tmp = ra;
			ra = rb;
			rb = tmp;
		}
		
		p[rb] = ra;
		s[ra] += s[rb];
		return true;
	}
	
	private static double kruskal(Edge[] edges) {
		Arrays.sort(edges);
		make();
		
		double mstCost = 0;
		int usedEdges = 0;
		
		for (Edge e : edges) {
			if (union(e.from, e.to)) {
				mstCost += e.weight;
				if (++usedEdges == n - 1) break;
			}
		}
		
		return mstCost;
	}
	
	private static double dist(int i, int j) {
		double dx = xs[i] - xs[j];
		double dy = ys[i] - ys[j];
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		xs = new double[n];
		ys = new double[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			xs[i] = Double.parseDouble(st.nextToken());
			ys[i] = Double.parseDouble(st.nextToken());
		}
		
		int m = n * (n - 1) / 2;
		int idx = 0;
		Edge[] edges = new Edge[m];
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				edges[idx++] = new Edge(i, j, dist(i, j));
			}
		}
		
		System.out.printf("%.2f", kruskal(edges));
		
	}

}
