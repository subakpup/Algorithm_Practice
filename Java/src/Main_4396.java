import java.io.*;

public class Main_4396 {
	static int n;
	static char[][] board, answer;
	static StringBuilder sb = new StringBuilder();
	
	static final int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static final int[] dc = { 0, 0, -1, 1, 1, -1, 1, -1 };
	
	private static int solve(int r, int c) {
		int cnt = 0;
		
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
			if (board[nr][nc] == '*') ++cnt;
		}
		
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		board = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		answer = new char[n][n];
		boolean flag = false;
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				if (s.charAt(j) == 'x') {
					if (board[i][j] == '*') {
						flag = true;
						continue;
					}
					answer[i][j] = (char) (solve(i, j) + '0');
				} else {
					answer[i][j] = '.';
				}
			}
		}
		
		if (flag) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == '*') answer[i][j] = '*';
				}
			}
		}
		
		for (char[] line : answer) {
			for (char c : line) sb.append(c);
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
