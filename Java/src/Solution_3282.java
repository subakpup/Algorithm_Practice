
/*
 * Solution_3282 0/1 Knapsack
 * 
 * # 문제 정리
 *  - 물건 `N`개
 *  - 각 물건은 무게 `V`와 가치 `C`를 가짐
 *  - 최대 `K`만큼의 무게만을 넣을 수 있는 배낭
 *  - 배낭에 넣을 수 있는 물건들의 가치의 최댓값 출력
 *  
 * # 아이디어
 *  - 0/1 Knapsack Problem
 */

import java.util.*;
import java.io.*;

public class Solution_3282 {
	static StringBuilder sb = new StringBuilder();
	static int n, k;
	static int[] dp;
	static int[][] info;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
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
				int v = in[0], c = in[1];
				
				for (int i = k; i >= v; i--) {
					dp[i] = Math.max(dp[i], dp[i-v] + c);
				}
			}
			
			sb.append("#" + tc + " " + dp[k] + "\n");
		}
		System.out.println(sb.toString());
	}
}
