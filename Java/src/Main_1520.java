import java.util.*;
import java.io.*;

public class Main_1520 {
	static int n, m;
	static int[][] map, dp;
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	private static int dfs(int r, int c) {
		if (r == n-1 && c == m-1) return 1;
		
		if (dp[r][c] != -1) return dp[r][c];
		
		dp[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
			if (map[nr][nc] < map[r][c]) {
				dp[r][c] += dfs(nr, nc);
			}
		}
		
		return dp[r][c];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[n][m];
		for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
		
		System.out.println(dfs(0, 0));
	}

}
