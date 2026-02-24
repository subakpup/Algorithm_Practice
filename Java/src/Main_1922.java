import java.util.*;
import java.io.*;

public class Main_1922 {
	static int n, m;
	static int[] p, s;
	
	
	static class Edge implements Comparable<Edge> {
		int from, to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
		
	}
	
	private static void make() {
		p = new int[n+1];
		s = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
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
	
	private static int kruskal(Edge[] edges) {
		make();
		Arrays.sort(edges);
		
		int mstCost = 0;
		int usedEdges = 0;
		
		for (Edge e : edges) {
			if (union(e.from, e.to)) {
				mstCost += e.weight;
				if (++usedEdges == n - 1) break;
			}
		}
		
		return mstCost;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		Edge[] edges = new Edge[m];
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(a, b, c);
		}
		
		System.out.println(kruskal(edges));
		
	}

}
