/*
 * Solution_5215 햄버거 다이어트 (D3)
 * 
 * # 문제 정리
 *  - 다음 조건에서 가장 선호하는 햄버거 조합 점수 출력
 *   - 햄버거 재료에 대한 점수
 *   - 최대 칼로리
 *   
 * # 아이디어
 *  - knapsack 문제를 응용하면 될 거 같다
 *  - 허용하는 최대 칼로리에서 주어진 칼로리를 제외하고 점수를 포함시키자
 *  - 현재 값과 칼로리를 제외하고 점수를 올렸을 때 값 중 최댓값을 계속 갱신
 *  - 모든 항목을 검사 후 인덱스 l번에 저장된 값 출력
 */

import java.util.*;
import java.io.*;

public class Solution_5215 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine()); // 테스트 케이스
		for (int tc = 1; tc <= t; tc++) {
			// 재료의 수, 제한 칼로리
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			// 재료의 정보 저장
			int[][] arr = new int[n+1][2];
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken()); // 점수
				arr[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
			}

			// 최적의 조합 계산
			int[] dp = new int[l+1]; // 칼로리 별로 최적의 조합을 저장할 배열
			for (int[] e : arr) {
				int score = e[0]; // 점수
				int cal = e[1]; // 칼로리
				
				for (int i = l; i >= cal; i--) {
					// 현재값과 칼로리를 제외하고 점수를 추가했을 때의 값 비교
					dp[i] = Math.max(dp[i-cal] + score, dp[i]);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(dp[l]).append("\n");
			
		}
		System.out.println(sb);
	}

}


// ============================================ //
//
///*
// * Solution_5215 햄버거 다이어트 (D3)
// * 
// * # 문제 정리
// *  - 다음 조건에서 가장 선호하는 햄버거 조합 점수 출력
// *   - 햄버거 재료에 대한 점수
// *   - 최대 칼로리
// *   
// * # 아이디어
// *  - 부분 집합 이용
// *  - 재료를 선택하는 경우, 선택하지 않는 경우 2가지 모두 고려
// *  - 선택을 했는데, 최대 칼로리를 넘어가는 경우는 pass
// *  - 최대 칼로리를 넘지 않는 선에서 가장 높은 점수 출력
// */
//
//import java.util.*;
//import java.io.*;
//
//public class Solution_5215 {
//	static StringBuilder sb = new StringBuilder();
//	static int n,l; // 재료의 수, 제한 칼로리
//	static int[][] arr; // 재료를 담을 배열
//	static int answer; // 정답
//	
//	public static void dfs(int depth, int score, int cal) {
//		// 제한 칼로리를 넘길 경우 pass
//		if (cal > l) {
//			return;
//		}
//		
//		// 깊이에 도달했을 경우 정답값 업데이트
//		if (depth == n) {
//			answer = Math.max(answer, score);
//			return;
//		}
//		
//		// 해당 재료를 고르지 않았을 경우
//		dfs(depth + 1, score, cal);
//		
//		// 재료를 골랐을 경우
//		dfs(depth + 1, arr[depth][0] + score, arr[depth][1] + cal);
//	}
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int t = Integer.parseInt(br.readLine()); // 테스트 케이스
//		for (int tc = 1; tc <= t; tc++) {
//			// 재료의 수, 제한 칼로리
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			n = Integer.parseInt(st.nextToken());
//			l = Integer.parseInt(st.nextToken());
//
//			// 재료의 정보 저장
//			arr = new int[n][2];
//			for (int i = 0; i < n; i++) {
//				st = new StringTokenizer(br.readLine());
//				arr[i][0] = Integer.parseInt(st.nextToken()); // 점수
//				arr[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
//			}
//
//			answer = 0;
//			dfs(0, 0, 0); // 0점에서 시작
//			sb.append("#").append(tc).append(" ").append(answer).append("\n");
//
//		}
//		System.out.println(sb);
//	}
//
//}
