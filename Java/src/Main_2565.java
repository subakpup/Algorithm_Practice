/*
 * Main_2565 전깃줄 (골드 5)
 *  - 메모리: 11644
 *  - 시간: 72
 *  
 * # 문제 정리
 *  - 전깃줄을 없애 전깃줄을 교차하지 않도록 만드려고 한다.
 *  - 전깃줄이 서로 교차하지 않게 없애야 하는 전깃줄의 최소 개수 출력
 * 
 * # 아이디어
 *  - a를 기준으로 정렬했을 때 겹치는 전깃줄을 구할 수 있다
 *  - a가 정렬되었다고 가정하자
 *  - 2개의 전깃줄을 비교하는데(i < j) i번째 전깃줄의 b값과 j번째 전깃줄 b값을 이용하면 겹침 여부를 파악할 수 있다.
 *  - i번째 전깃줄의 b가 j번째 전깃줄의 b보다 크다면 겹치게 된다.
 *  - 이 말은 즉슨 앞에 있는 전깃줄의 b값이 뒤에 있는 전깃줄의 b값보다 작아야 겹치지 않는다는 것이다. 
 * 
 */

import java.util.*;
import java.io.*;

public class Main_2565 {
	
	// 전깃줄 클래스
	static class Pair implements Comparable<Pair> {
		int a, b;
		
		Pair (int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Pair o) {
			return this.a - o.a;
		}
	}
	
	static int n;
	static int[] dp;
	static Pair[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 전깃줄의 개수
		
		// 전깃줄 정보를 담는 배열
		arr = new Pair[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Pair(a, b);
		}
		
		// 예제와 일치하게 만들기 위해 A를 기준으로 정렬
		Arrays.sort(arr);
		
		// 겹치지 않게 배치할 수 있는 전깃줄
		dp = new int[n];
		Arrays.fill(dp, 1);
		
		int answer = 0;
		for (int i = 1; i < n; i++) { // i번째 전깃줄
			for (int j = 0; j < i; j++) { // i번째 보다 위에 있는 전깃줄
				if (arr[i].b > arr[j].b) { // i번째 전깃줄과 j번째 전깃줄이 겹치지 않는다면
					dp[i] = Math.max(dp[i], dp[j] + 1); // dp 배열에 겹치지 않는 전깃줄의 개수 저장
				}
			}
			answer = Math.max(answer, dp[i]); // 최댓값 업데이트
		}
		
		System.out.println(n - answer); // 제거해야 되는 전깃줄의 개수이므로 (전체 - 겹치지 않게 배치할 수 있는 최대 전깃줄의 개수)
	}
}
