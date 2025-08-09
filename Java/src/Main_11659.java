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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 수의 갯수
		int m = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수
		
		// 배열에 수 집어넣기
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 누적합 구하기
		int[] prefix = new int[n+1];
		for (int i = 1; i <= n; i++) {
			prefix[i] = arr[i] + prefix[i-1];
		}
		
		// 결과
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 시작 인덱스
			int y = Integer.parseInt(st.nextToken()); // 종료 인덱스
			int answer = prefix[y] - prefix[x-1]; // 종료 인덱스 구간합 - (시작 인덱스 - 1) 구간합
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
		
	}

}
