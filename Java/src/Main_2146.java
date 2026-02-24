import java.util.*;
import java.io.*;

public class Main_2146 {
	static int n, answer;
	static int[][] map;
	
	static int label = 2;
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	private static void grouping() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					groupBfs(i, j);
					label++;
				}
			}
		}
	}
	
	private static void groupBfs(int sr, int sc) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { sr, sc });
		map[sr][sc] = label;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				if (map[nr][nc] == 1) {
					map[nr][nc] = label;
					queue.add(new int[] { nr, nc });
				}
			}
		}
	}
	
	private static void build() {
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] > 1) {
					buildBfs(i, j, map[i][j]);
				}
			}
		}
	}
	
	private static void buildBfs(int sr, int sc, int start) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][n];
		
		queue.add(new int[] { sr, sc, 0 });
		visited[sr][sc] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1], len = cur[2];
			
			if (len > answer) continue;
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) continue;
				
				if (map[nr][nc] == 0) {
					visited[nr][nc] = true;
					queue.add(new int[] { nr, nc, len + 1 });
					continue;
				}
				
				if (map[nr][nc] != start) {
					answer = Math.min(answer, len);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		grouping();
		build();
		
		System.out.println(answer);

	}

}
