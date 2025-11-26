import java.util.*;
import java.io.*;

public class Main_2665 {
	
	static class Node implements Comparable<Node> {
		int r, c, cost;
		
		public Node (int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}
	
	static int n;
	static int[][] map, dist;
	
	static final int INF = 1_000_000_000;
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, 0));
		
		dist[0][0] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int r = cur.r;
			int c = cur.c;
			int cost = cur.cost;
			
			if (cost > dist[r][c]) continue;
			
			if (r == n - 1 && c == n - 1) {
				System.out.println(cost);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				
				if (dist[nr][nc] > dist[r][c] + map[nr][nc]) {
					dist[nr][nc] = dist[r][c] + map[nr][nc];
					pq.add(new Node(nr, nc, dist[nr][nc]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		dist = new int[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = 1 - (s.charAt(j) - '0');
				dist[i][j] = INF;
			}
		}
		
		dijkstra();
	}
	
}
