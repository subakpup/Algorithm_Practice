import java.util.*;
import java.io.*;

public class Main_17472 {
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] p, s;
	static List<Edge> edges;
	static int label = 2;
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	static final int INF = 1_000_000_000;
	
	private static void grouping() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					bfs(i, j);
					label++;
				}
			}
		}
	}
	
	private static void bfs(int sr, int sc) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { sr, sc });
		visited[sr][sc] = true;
		map[sr][sc] = label;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i], nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				if (map[nr][nc] == 0 || visited[nr][nc]) continue;
				
				map[nr][nc] = label;
				visited[nr][nc] = true;
				queue.add(new int[] { nr, nc });
			}
		}
	}
	
	private static void make() {
		p = new int[label];
		s = new int[label];
		
		for (int i = 2; i < label; i++) {
			p[i] = i;
			s[i] = 1;
		}
	}
	
	private static void buildEdges() {
		int[][] lens = new int[label][label];
		for (int i = 2; i < label; i++) Arrays.fill(lens[i], INF);
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				int start = map[r][c];
				if (start <= 1) continue;
				
				for (int i = 0; i < 4; i++) {
					int len = 0;
					int nr = r + dr[i], nc = c + dc[i];
					
					while (0 <= nr && nr < n && 0 <= nc && nc < m) {
						int bridge = map[nr][nc];
						
						if (bridge == start) break;
						
						if (bridge == 0) {
							len++;
							nr += dr[i];
							nc += dc[i];
							continue;
						}
						
						if (len >= 2) {
							int end = bridge;
							if (lens[start][end] > len) {
								lens[start][end] = len;
								lens[end][start] = len;
							}
						}
						break;
					}
				}
			}
		}
		
		edges = new ArrayList<>();
		for (int u = 2; u < label; u++) {
			for (int v = u + 1; v < label; v++) {
				if (lens[u][v] != INF) edges.add(new Edge(u, v, lens[u][v]));
			}
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
				if (++usedEdges == label - 3) {
					return mstCost;
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		grouping();
		make();
		buildEdges();
		
		System.out.println(kruskal());
	}

}

class Edge implements Comparable<Edge> {
	int u, v, w;
	
	Edge (int u, int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}
	
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.w, o.w);
	}
	
}
