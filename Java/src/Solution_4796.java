/*
 * Solution_4796 의석이의 우뚝 선 산 (D4)
 * # 문제 정리
 *  - 동서 방향으로 늘어서 있는 산의 N개의 지점
 *  - 서쪽방향 기준 i번 지점(높이: h[i])
 *   - 같은 높이 X
 *   - 두 지점 i,j 사이에 있는 모든 지점 관찰
 *  - 다음을 만족하는 k가 존재해야 한다.
 *   1. i <= l < k
 *   2. k <= l < j
 *
 * # 아이디어
 *  - 1부터 n-1까지 반복하여 양옆 값들을 비교해본다
 *  - 그리고 양옆으로 뻗어나가면서 그 값들이 계속 내림차순인지 확인해본다!
 *  - 내림차순의 개수가 몇 개인지 카운팅하여 구한 값들을 곱하면 모든 지점들을 구할 수 있다!
 *  (파이썬으로 제출이 안 돼서 자바로 풀었습니다 ㅜㅡㅜ)
 */

import java.util.*;
import java.io.*;

public class Solution {
	static int t, n, answer;
	static int[] h;
	static StringBuilder sb = new StringBuilder();
	
	// 양옆 탐색
	public static int func() {
		int cnt = 0;
		for (int i = 1; i < n-1; i++) {
			if (h[i-1] < h[i] && h[i+1] < h[i]) { // 우뚝 솟았다면
				cnt += down(i) * up(i); // 계속 탐색
			}
		}
		return cnt; // 탐색을 마치면 리턴
	}
	
	// 인덱스 번호부터 서쪽에 있는 산들 오름차순인지 탐색
	public static int down(int idx) {
		int cnt = 0;
		for (int i = idx; i > 0; i--) {
			if (h[i-1] >= h[i]) break;
			cnt++;
		}
		return cnt;
	}
	
	// 인덱스 번호부터 동쪽에 있는 산들 내림 차순인지 탐색
	public static int up(int idx) {
		int cnt = 0;
		for (int i = idx; i < n-1; i++) {
			if (h[i+1] >= h[i]) break;
			cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt(); // 산의 개수      
			sc.nextLine();
			
			// 산의 높이 정보
			h = new int[n];
			for (int i = 0; i < n; i++) {
				h[i] = sc.nextInt();
			}
			
			sb.append("#" + tc + " " + func() + "\n");
		}
		System.out.println(sb);
	}

}
