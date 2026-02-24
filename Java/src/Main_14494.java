import java.util.*;
import java.io.*;

public class Main_14494 {
	static int n, m;
	static long[][] dp;
	static final int MOD = 1000000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dp = new long[n+1][m+1];
		dp[1][1] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (i == 1 && j == 1) continue;
				dp[i][j] = (dp[i-1][j] + dp[i][j-1] + dp[i-1][j-1]) % MOD;
			}
		}
		
		System.out.println(dp[n][m]);
	}
}
