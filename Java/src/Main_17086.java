import java.util.*;
import java.io.*;

public class Main_17086 {
	static int n, m;
	static int[][] map, dist;
	static int[][] dir;
	static int answer = 0;
	
	// 8방향 설정
	private static void makeDir() {
		dir = new int[8][2];
		int idx = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i == 0 && j == 0) continue;
				dir[idx][0] = i;
				dir[idx++][1] = j;
			}
		}
	}
	
	private static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					dist[i][j] = 0;
					queue.add(new int[] {i, j});
				}
			}
		}
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			
			for (int i = 0; i < 8; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				if (dist[nr][nc] != -1) continue;
				
				dist[nr][nc] = dist[r][c] + 1;
				queue.add(new int[] {nr, nc});
				if (answer < dist[nr][nc]) answer = dist[nr][nc];
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dist[i][j] = -1;
			}
		}
		
		makeDir();
		bfs();
		
		System.out.println(answer);
	}
}
