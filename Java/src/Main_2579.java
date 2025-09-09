/*
 * Main_2579 계단 오르기 (실버 3)
 *  - 메모리: 11624
 *  - 시간: 72
 *  
 * # 문제 정리
 *  - 계단 오르기 게임은 계단 아래 시작점부터 꼭대기에 위치한 도착점까지 가는 게임
 *  1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다.
 *  2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함 X
 *  3. 마지막 도착 계단은 반드시 밟아야 한다.
 *  
 * # 아이디어
 *  - 계단이 2개 이하일 경우엔 무조건 모든 계단의 합이 최댓값이 된다.
 *  - 3개일 경우에는 1, 3번 계단이거나 2, 3번 계단의 합을 비교해야 한다.
 *  - 4개부터는 다음 점화식을 적용해서 풀 수 있다.
 *   - i번째 계단의 최댓값 = i번째 계단의 값 + (i-2)번째 계단까지의 최댓값 || i번째 계단의 값 + (i-1)번째 계단의 값 + (i-3)번째 계단까지의 최댓값
 *  
 */

import java.util.*;
import java.io.*;

public class Main_2579 {
	static int n, answer;
	static int[] stair, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		stair = new int[n];
		for (int i = 0; i < n; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		if (n == 1) {
			answer = stair[0];
		} else if (n == 2) {
			answer = stair[0] + stair[1];
		} else {
			dp = new int[n];
			dp[0] = stair[0];
			dp[1] = stair[0] + stair[1];
			dp[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);
			
			for (int i = 3; i < n; i++) {
				dp[i] = stair[i] + Math.max(dp[i-2], stair[i-1] + dp[i-3]);
			}
			
			answer = dp[n-1];
		}
		
		System.out.println(answer);
		
	}
}
