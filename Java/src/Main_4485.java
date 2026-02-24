import java.util.*;
import java.io.*;

public class Main_4485 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[][] map;
	static int idx = 1;

	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };

	private static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { 0, 0 });
		int[][] visited = new int[n][n];
		for (int i = 0; i < n; i++) Arrays.fill(visited[i], Integer.MAX_VALUE);
		visited[0][0] = map[0][0];
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				
				int nxt = visited[r][c] + map[nr][nc];
				if (visited[nr][nc] > nxt) {
					visited[nr][nc] = nxt;
					queue.add(new int[] {nr, nc});
				}
			}
		}
		
		return visited[n-1][n-1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) break;

			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("Problem " + idx++ + ": " + bfs() + "\n");
		}
		System.out.println(sb.toString());
	}
}
