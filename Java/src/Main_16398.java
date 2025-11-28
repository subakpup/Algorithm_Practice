import java.util.*;
import java.io.*;

public class Main_16398 {
	
	static class Edge implements Comparable<Edge> {
		
		int u, v, w;
		
		public Edge (int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	static int n;
	static int[] p, s;
	static List<Edge> edges;
	
	private static void make() {
		p = new int[n];
		s = new int[n];
		
		for (int i = 0; i < n; i++) {
			p[i] = i;
			s[i] = 1;
		}
	}
	
	private static int find(int x) {
		if (p[x] == x) return x;
		return p[x] = find(p[x]);
	}
	
	private static boolean union(int a, int b) {
		int ra = find(a), rb = find(b);
		
		if (ra == rb) return false;
		
		if (s[ra] < s[rb]) {
			int t = ra;
			ra = rb;
			rb = t;
		}
		
		p[rb] = ra;
		s[ra] += s[rb];
		return true;
	}
	
	private static long kruskal() {
		Collections.sort(edges);
		
		long mstCost = 0;
		int usedEdges = 0;
		
		for (Edge e : edges) {
			if (union(e.u, e.v)) {
				mstCost += e.w;
				if (++usedEdges == n - 1) break;
			}
		}
		
		return mstCost;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		edges = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int w = Integer.parseInt(st.nextToken());
				if (i < j) edges.add(new Edge(i, j, w));
			}
		}
		
		make();
		System.out.println(kruskal());
	}

}
