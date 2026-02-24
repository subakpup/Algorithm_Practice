import java.io.*;
import java.util.*;

public class Main_6497 {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	static int m, n, total;
	static int[] p, s;
	static Edge[] edges;

	private static void makeSet() {
		p = new int[m];
		s = new int[m];
		for (int i = 0; i < m; i++) {
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
			int tmp = ra;
			ra = rb;
			rb = tmp;
		}

		p[rb] = ra;
		s[ra] += s[rb];
		return true;
	}

	private static int kruskal() {
		makeSet();
		Arrays.sort(edges);

		int mstCost = 0;
		int usedEdges = 0;

		for (Edge e : edges) {
			if (union(e.from, e.to)) {
				mstCost += e.weight;
				if (++usedEdges == m - 1) break;
			}
		}

		return mstCost;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			if (m == 0 && n == 0) break;
			
			edges = new Edge[n];
			total = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(a, b, c);
				total += c;
			}

			System.out.println(total - kruskal());
		}
	}

}
