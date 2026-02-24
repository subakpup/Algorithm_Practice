import java.util.*;
import java.io.*;

public class Main_2206 {
	
	static class Loc {
		int r, c, dist;
		boolean used;
		
		public Loc (int r, int c, int dist, boolean used) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.used = used;
		}
	}
	
	static int n, m;
	static int[][] map;
	static boolean[][][] visited;
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	private static int bfs() {
		Queue<Loc> queue = new ArrayDeque<>();
		queue.add(new Loc(0, 0, 1, false));
		
		visited[0][0][0] = true;
		
		while (!queue.isEmpty()) {
			Loc cur = queue.poll();
			int r = cur.r;
			int c = cur.c;
			
			if (r == n-1 && c == m-1) return cur.dist;
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				
				// 다음 경로 탐색
				// 벽이 아닐 경우
				if (map[nr][nc] == 0) {
					if (!cur.used && !visited[nr][nc][0]) {
						queue.add(new Loc(nr, nc, cur.dist + 1, false));
						visited[nr][nc][0] = true;
					} else if (cur.used && !visited[nr][nc][1]) {
						queue.add(new Loc(nr, nc, cur.dist + 1, true));
						visited[nr][nc][1] = true;
					}
				}
				// 벽일 경우
				else {
					if (!cur.used && !visited[nr][nc][1]) {
						queue.add(new Loc(nr, nc, cur.dist + 1, true));
						visited[nr][nc][1] = true;
					}
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
		visited = new boolean[n][m][2];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs());
	}

}
