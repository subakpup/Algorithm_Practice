import java.io.*;
import java.util.*;

public class Main_1774 {

	static class Pos {
		int id, x, y;
		
		public Pos (int id, int x, int y) {
			this.id = id;
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int u, v;
		double w;
		
		public Edge (int u, int v, double w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}
	}
	
	static int n, m;
	static int[] p, s;
	static Pos[] pos;
	static List<Edge> edges;
	
	private static void make() {
		p = new int[n+1];
		s = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			p[i] = i;
			s[i] = i;
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
	
	private static double kruskal() {
		Collections.sort(edges);
		
		double mstCost = 0.0;
		int usedEdges = 0;
		
		for (Edge e : edges) {
			if (union(e.u, e.v)) {
				mstCost += e.w;
				if (++usedEdges == n - 1) break;
			}
		}
		
		return mstCost;
	}
	
	private static void link() {
		edges = new ArrayList<>();
		
		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				long dx = pos[i].x - pos[j].x;
				long dy = pos[i].y - pos[j].y;
				double weight = Math.sqrt(dx * dx + dy * dy);
				edges.add(new Edge(i, j, weight));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		make();
		
		pos = new Pos[n+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pos[i] = new Pos(i, x, y);
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			union(u, v);
		}
		
		link();
		System.out.println(String.format("%.2f", kruskal()));
		
	}

}
