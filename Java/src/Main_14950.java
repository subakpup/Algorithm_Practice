import java.util.*;
import java.io.*;

public class Main_14950 {
	
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
	
	static int n, m, t;
	static int[] p, s;
	static List<Edge> edges;
	static int answer = Integer.MAX_VALUE;
	
	private static void make() {
		p = new int[n+1];
		s = new int[n+1];
		for (int i = 0; i <= n; i++) {
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
	
	private static int kruskal() {
		Collections.sort(edges);
		
		int mstCost = 0;
		int usedEdges = 0;
		
		for (Edge e : edges) {
			if (union(e.u, e.v)) {
				mstCost += e.w + (usedEdges++ * t);
				if (usedEdges == n-1) break;
			}
		}
		
		return mstCost;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		edges = new ArrayList<>();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges.add(new Edge(a, b, c));
		}
		
		make();
		System.out.println(kruskal());
	}

}
