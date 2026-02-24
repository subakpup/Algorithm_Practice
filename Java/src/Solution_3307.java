
/*
 * Solution_3307 최장 증가 부분 수열 (D3)
 * 
 * # 문제 정리
 *  - 두 수열의 최장 증가 부분수열의 길이 출력
 *  
 * # 아이디어
 *  - 각 인덱스의 최장 길이를 1로 초기화 하자(자기 자신만으로도 최장 증가 부분 수열이 될 수 있으므로)
 */

import java.util.*;
import java.io.*;

public class Solution_3307 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] arr, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			// 수열 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// dp 배열 초기화(모든 길이 1로 설정)
			dp = new int[n];
			Arrays.fill(dp, 1);
			
			// 자신 보다 작은 숫자들이 발견되면, 값 증가
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if (arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			
			int answer = 0;
			for (int v : dp) {
				if (answer < v) answer = v;
			}
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}
}
