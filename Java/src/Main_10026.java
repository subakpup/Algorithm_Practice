import java.util.*;
import java.io.*;

public class Main_10026 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static char[][] map;
	static boolean[][] visited;
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	private static void solve() {
		visited = new boolean[n][n];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(i, j, map[i][j]);
					++cnt;
				}
			}
		}
		
		sb.append(cnt).append(' ');
	}
	
	private static void bfs(int sr, int sc, char start) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { sr, sc });
		
		visited[sr][sc] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				if (map[nr][nc] != start || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				queue.add(new int[] { nr, nc });
			}
		}
	}
	
	private static void rgb() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'G') map[i][j] = 'R';
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		solve();
		rgb();
		solve();
		System.out.println(sb.toString());
	}

}
