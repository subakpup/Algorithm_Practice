import java.util.*;
import java.io.*;

public class Main_1780 {
	static int n;
	static int[][] map;
	static int answer1, answer2, answer3;
	
	private static void division(int x, int y, int len) {
		int point = map[x][y];
		boolean flag = true;
		
		for (int r = x; r < x + len; r++) {
			for (int c = y; c < y + len; c++) {
				if (map[r][c] != point) flag = false;
			}
		}
		
		if (!flag) {
			int l = len / 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					division(x + l * i, y + l * j, l);
				}
			}
			return;
		}
		
		if (point == -1) {
			answer1++;
		} else if (point == 0) {
			answer2++;
		} else {
			answer3++;
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
		
		division(0, 0, n);
		System.out.println(answer1 + "\n" + answer2 + "\n" + answer3);
	}

}
