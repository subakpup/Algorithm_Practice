import java.util.*;
import java.io.*;

public class Main_2638 {
	static int n, m, cheese, cnt;
	static int[][] map;
	static boolean[][] visited;
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	private static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { 0, 0 });
		
		visited = new boolean[n][m];
		visited[0][0] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) continue;
				
				if (map[nr][nc] == 0) {
					queue.add(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
		}
		
		search();
	}
	
	private static void search() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) melt(i, j);
			}
		}
	}
	
	private static void melt(int r, int c) {
		int air = 0;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
			
			if (visited[nr][nc]) ++air;
		}
		
		if (air >= 2) {
			map[r][c] = 0;
			--cheese;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		cheese = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) ++cheese;
			}
		}
		
		cnt = 0;
		while (cheese > 0) {
			++cnt;
			bfs();
		}
		
		System.out.println(cnt);
	}

}
