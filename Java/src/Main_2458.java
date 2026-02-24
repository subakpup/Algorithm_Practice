import java.util.*;
import java.io.*;

public class Main_2458 {
	static StringTokenizer st;
	static int n, m, answer;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (map[i][k] == 1 && map[k][j] == 1) {
						map[i][j] = 1;
					}
				}
			}
		}

		answer = 0;
		for (int i = 1; i <= n; i++) {
			int tall = 0;
			int small = 0;
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 1) {
					tall++;
				} else if (map[j][i] == 1) {
					small++;
				}
			}
			if (tall + small == n - 1) {
				answer++;
			}
		}

		System.out.println(answer);
	}

}
