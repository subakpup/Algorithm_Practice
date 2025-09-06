
import java.util.*;
import java.io.*;

public class Main_7576 {
	static int m, n;
	static int answer = 0;
	static int[][] box;
	static Queue<int[]> queue = new ArrayDeque<>();
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	private static void bfs() {

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				if (box[nr][nc] == -1 || box[nr][nc] != 0) continue;
				
				box[nr][nc] = box[r][c] + 1;
				queue.add(new int[] {nr, nc});
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		boolean flag = false;
		box = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 0) flag = true;
				if (box[i][j] == 1) queue.add(new int[] {i, j});
			}
		}
		
		
		if (flag) {
			bfs();
			search:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (box[i][j] == 0) {
						answer = -1;
						break search;
					}
					if (box[i][j] > answer) answer = box[i][j] - 1;
				}
			}
		}
		
		System.out.println(answer);
	}
}
