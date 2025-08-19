/*
 * Solution_14510 나무 높이 (D2)
 * 
 * # 문제 정리
 *  - N개의 나무
 *  - 홀수 날엔 1씩
 *  - 짝수 날엔 2씩 자란다.
 *  - 물은 안 줄 수도 있다.
 *  - 모든 나무의 키가 처음에 가장 키가 컸던 나무와 같아지도록 할 수 있는 최소 날짜 수
 *  
 * # 아이디어
 *  - while 문을 이용해 홀수날에 줘야 하는 물과 짝수 날에 줘야 하는 물이 있을 경우 반복했으나..
 *  - 실패하고 다른 사람의 코드를 참고해 공부했습니다..
 */

import java.util.*;
import java.io.*;

public class Solution_14510 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine()); // 나무 수
			int[] trees = new int[n]; // 나무들의 높이를 저장할 배열
			int max = 0; // 나무의 최대 길이
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				if (max < trees[i])
					max = trees[i];
			}

			int[] heights = new int[n]; // 자라야 하는 높이를 저장할 배열
			int sum = 0; // 총 키워야 할 나무 높이
			for (int i = 0; i < n; i++) {
				heights[i] = max - trees[i];
				sum += max - trees[i];
			}

			int even = 0; // 짝수날(2씩)에 줘야 하는 횟수
			for (int i = 0; i < n; i++) {
				even += heights[i] / 2;
			}

			int answer = Integer.MAX_VALUE; // 최솟값 비교
			for (int i = 0; i <= even; i++) {
				int cnt1 = sum - i * 2; // 홀수 날
				int cnt2 = i; // 짝수 날
				// 각 날짜에 더 줘야 하는 날이 긴 경우가 우리가 물을 줘야 하는 총 일자다.
				// 총 날짜와 정답 변수에 저장된 값과 비교하여 최솟값을 출력한다.
				answer = Math.min(answer, Math.max(cnt1 * 2 - 1, cnt2 * 2));
			}
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb);
	}

}
