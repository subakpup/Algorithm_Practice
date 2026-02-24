import java.util.*;
import java.io.*;

public class Main_2887 {
	
	static class Pos {
		int id, x, y, z;
		
		public Pos (int id, int x, int y, int z) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
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
	static List<Pos> points;
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
	
	private static int kruskal() {
		Collections.sort(edges);
		
		int mstCost = 0;
		int usedEdges = 0;
		
		for (Edge e : edges) {
			if (union(e.u, e.v)) {
				mstCost += e.w;
				if (++usedEdges == n-1) break;
			}
		}
		
		return mstCost;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		points = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			points.add(new Pos(i, x, y, z));
		}
		
		edges = new ArrayList<>();
		
		// x축 기준 정렬
		Collections.sort(points, (p1, p2) -> Integer.compare(p1.x, p2.x));
		for (int i = 0; i < n-1; i++) {
			Pos p1 = points.get(i);
			Pos p2 = points.get(i+1);
			int weight = Math.abs(p1.x - p2.x);
			edges.add(new Edge(p1.id, p2.id, weight));
		}
		
		// y축 기준 정렬
		Collections.sort(points, (p1, p2) -> Integer.compare(p1.y, p2.y));
		for (int i = 0; i < n-1; i++) {
			Pos p1 = points.get(i);
			Pos p2 = points.get(i+1);
			int weight = Math.abs(p1.y - p2.y);
			edges.add(new Edge(p1.id, p2.id, weight));
		}
		
		// z축 기준 정렬
		Collections.sort(points, (p1, p2) -> Integer.compare(p1.z, p2.z));
		for (int i = 0; i < n-1; i++) {
			Pos p1 = points.get(i);
			Pos p2 = points.get(i+1);
			int weight = Math.abs(p1.z - p2.z);
			edges.add(new Edge(p1.id, p2.id, weight));
		}
		
		make();
		System.out.println(kruskal());
	}

}
