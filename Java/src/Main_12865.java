import java.util.*;
import java.io.*;

public class Main_12865 {
	static int n, k;
	static int[] dp;
	static int[][] info;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		info = new int[n+1][2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[k+1];
		for (int[] in : info) {
			int w = in[0];
			int v = in[1];
			
			for (int i = k; i >= w; i--) {
				dp[i] = Math.max(dp[i], dp[i-w] + v);
			}
		}
		
		System.out.println(dp[k]);
	}
}
