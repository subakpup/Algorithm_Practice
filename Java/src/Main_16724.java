import java.util.*;
import java.io.*;

public class Main_16724 {
	static int n, m;
	static int[][] map, visited;
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	static int SAFE_ZONE = 0;
	
	private static int getDirection(char c) {
		switch (c) {
			case 'U': return 0;
			case 'D': return 1;
			case 'L': return 2;
			default: return 3;
		}
	}

	private static void solve() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == 0) {
					dfs(i, j);
				}
			}
		}
	}
	
	private static void dfs(int r, int c) {
		visited[r][c] = 1;
		
		int nr = r + dr[map[r][c]];
		int nc = c + dc[map[r][c]];
		
		if (visited[nr][nc] == 0) {
			dfs(nr, nc);
		} else if (visited[nr][nc] == 1) {
			++SAFE_ZONE;
		}
		
		visited[r][c] = 2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = getDirection(s.charAt(j));
			}
		}
		
		solve();
		System.out.println(SAFE_ZONE);
	}

}
