import java.util.*;
import java.io.*;

public class Main_9465 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] sticker = new int[2][n];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dp = new int[2][n];
			
			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];
			
			if (n > 1) {
				dp[0][1] = sticker[1][0] + sticker[0][1];
				dp[1][1] = sticker[0][0] + sticker[1][1];
			}
			
			if (n > 2) {
				for (int i = 2; i < n; i++) {
					dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + sticker[0][i];
					dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + sticker[1][i];
				}
			}
			
			int answer = Math.max(dp[0][n-1], dp[1][n-1]);
			System.out.println(answer);
		}
	}

}
