import java.util.*;
import java.io.*;

public class Main_14940 {
	static StringBuilder sb = new StringBuilder();
	static int n, m, sr, sc;
	static int[][] map;
	static boolean[][] visited;
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	private static void bfs() {
		visited[sr][sc] = true;
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {sr, sc});
		map[sr][sc] = 0;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) continue;
				
				map[nr][nc] = map[r][c] + 1;
				visited[nr][nc] = true;
				queue.add(new int[] { nr, nc });
			}
		}
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
				if (map[i][j] == 2) {
					sr = i; sc = j;
				} else if (map[i][j] == 0) visited[i][j] = true;
			}
		}
		
		bfs();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) sb.append(-1).append(" ");
				else sb.append(map[i][j]).append(" ");
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
