import java.util.*;
import java.io.*;

public class Main_11053 {
	static int n;
	static int[] A, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n];
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) if (A[j] < A[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
	}

}
