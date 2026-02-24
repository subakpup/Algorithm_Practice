import java.util.*;
import java.io.*;

public class Main_1261 {
	static int n, m;
	static int[][] map;
	
	static final int INF = 1_000_000_000;
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	private static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { 0, 0 });
		
		int[][] dist = new int[n][m];
		for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);
		dist[0][0] = 0;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				
				if (dist[nr][nc] > dist[r][c] + map[nr][nc]) {
					dist[nr][nc] = dist[r][c] + map[nr][nc];
					queue.add(new int[] { nr, nc });
				}
			}
		}
		
		return dist[n-1][m-1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs());
		
	}

}
