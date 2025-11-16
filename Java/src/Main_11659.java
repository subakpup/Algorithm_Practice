/*
 * Main_11659 구간 합 구하기 4 (실버3)
 * - 메모리: 61088KB
 * - 시간: 564ms
 * 
 * # 문제 정리
 *  - N개의 수
 *  - i번째 수부터 j번째 수까지 합 출력
 *  
 * # 아이디어
 *  - 누적합을 이용하면 될 것 같다!
 */

import java.util.*;
import java.io.*;

public class Main_11659 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		nums = new int[n+1];
		for (int i = 1; i <= n; i++) {
			nums[i] = nums[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(nums[b] - nums[a-1]).append('\n');
		}
		
		System.out.println(sb.toString());
	}

}

