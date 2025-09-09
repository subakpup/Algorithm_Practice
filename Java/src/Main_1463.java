/*
 * Main_1463 1로 만들기 (실버 3)
 *  - 메모리: 15632
 *  - 시간: 92
 *  
 * # 문제 정리
 *  - 정수 X에 사용할 수 있는 연산
 *   1. X가 3으로 나누어 떨어지면, 3으로 나눔
 *   2. X가 2로 나누어 떨어지면, 2로 나움
 *   3. 1을 뺀다
 *  - 정수 N이 주어졌을 때, 연산 3개를 적절히 사용해서 1로 만드려고 함
 *  - 연산을 사용하는 횟수의 최솟값 출력
 *  
 * # 아이디어
 *  - 1을 뺀 연산을 진행한 횟수를 현재 dp에 메모
 *  - 2나 3으로 나누어 떨어지면 그 값 + 1과 비교하여 최솟값 저장
 *  
 */

import java.util.*;
import java.io.*;

public class Main_1463 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1000001];
		
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + 1;
			if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
			if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
		}
		
		System.out.println(dp[n]);
		
	}
}
