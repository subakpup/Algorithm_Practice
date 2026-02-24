import java.io.*;
import java.util.*;

public class Main_7579 {
	static int N, M;
	static int[] m, c;
	static int[][] dp;
	static final int INF = (int) 1e9;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		m = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		
		c = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxCost = 0;
		for (int x : c) maxCost += x;
		
		dp = new int[N+1][maxCost + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= maxCost; j++) {
				dp[i][j] = dp[i-1][j];
				if (j >= c[i]) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j - c[i]] + m[i]);
				}
			}
		}
		
		int answer = INF;
		for (int i = 0; i <= maxCost; i++) {
			if (dp[N][i] >= M) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
