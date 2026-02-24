import java.util.*;
import java.io.*;

public class Main_14442 {
	
	static class Loc {
		int r, c, dist, crash;
		
		public Loc (int r, int c, int dist, int crash) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.crash = crash;
		}
	}
	
	static int n, m, k;
	static int[][] map;
	static boolean[][][] visited;
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	private static int bfs() {
		Queue<Loc> queue = new ArrayDeque<>();
		queue.add(new Loc(0, 0, 1, 0));
		
		visited[0][0][0] = true;
		
		while (!queue.isEmpty()) {
			Loc cur = queue.poll();
			
			if (cur.r == n-1 && cur.c == m-1) return cur.dist;
			
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				
				if (map[nr][nc] == 0) {
					if (!visited[nr][nc][cur.crash]) {
						visited[nr][nc][cur.crash] = true;
						queue.add(new Loc(nr, nc, cur.dist + 1, cur.crash));
					}
				} else {
					if (cur.crash < k && !visited[nr][nc][cur.crash + 1]) {
						visited[nr][nc][cur.crash + 1] = true;
						queue.add(new Loc(nr, nc, cur.dist + 1, cur.crash + 1));
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
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		visited = new boolean[n][m][k+1];
		System.out.println(bfs());
	}

}
