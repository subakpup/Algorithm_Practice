import java.util.*;
import java.io.*;

public class Main_1012 {
	static StringBuilder sb = new StringBuilder();
	static int m, n, k;
	static boolean[][] map, visited;
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	private static void bfs(int sr, int sc) {
		visited[sr][sc] = true;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {sr, sc});
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m || !map[nr][nc] || visited[nr][nc]) continue;
				
				queue.add(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map = new boolean[n][m];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = true;
			}
			
			visited = new boolean[n][m];
			int answer = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] && !visited[i][j]) {
						bfs(i, j);
						answer++;
					}
				}
			}
			sb.append(answer).append('\n');
		}
		System.out.println(sb.toString());
	}

}
