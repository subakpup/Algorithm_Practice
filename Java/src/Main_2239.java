import java.io.*;

public class Main_2239 {
	static int[][] board = new int[9][9];
	static boolean[][] rows = new boolean[9][10];
	static boolean[][] cols = new boolean[9][10];
	static boolean[][] box = new boolean[9][10];
	
	private static void dfs(int r, int c) {
		if (r == 9) {
			for (int[] line : board) {
				for (int v : line) System.out.print(v);
				System.out.println();
			}
			
			System.exit(0);
		}
		
		if (board[r][c] != 0) {
			dfs(r + (c+1) / 9, (c+1) % 9);
			return;
		}
		
		for (int i = 1; i <= 9; i++) {
			if (rows[r][i] || cols[c][i] || box[(r/3)*3 + (c/3)][i]) continue;
			
			board[r][c] = i;
			rows[r][i] = true;
			cols[c][i] = true;
			box[(r/3*3) + (c/3)][i] = true;
			
			dfs(r + (c+1) / 9, (c+1) % 9);
			
			board[r][c] = 0;
			rows[r][i] = false;
			cols[c][i] = false;
			box[(r/3*3) + (c/3)][i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				board[i][j] = s.charAt(j) - '0';
				if (board[i][j] != 0) {
					rows[i][board[i][j]] = true;
					cols[j][board[i][j]] = true;
					box[(i/3)*3 + (j/3)][board[i][j]] = true;
				}
			}
		}
		
		dfs(0, 0);
	}

}
