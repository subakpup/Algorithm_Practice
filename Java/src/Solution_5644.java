/*
 * Solution_5644 무선 충전
 * 
 * # 문제 정리
 *  - 10 * 10 영역의 지도
 *   - 위치 (X, Y)
 *   - 충전 범위 C
 *   - 성능 P
 *  - BC의 충전 범위가 C일 때, BC와의 거리가 C 이하이면 BC에 접속할 수 있다.
 *   - 두 지점 사이의 거리 맨해튼 거리
 *  - 사용자 A와 B의 이동 궤적이 주어짐
 *  - 만약 한 BC에 두 명의 사용자가 접속한 경우, 접속한 사용자의 수만큼 충전 양을 균등하게 분배한다.
 *  
 * # 아이디어
 *  - 지도를 3차원으로 입력 받아 3번째 배열에 충전소의 충전량 값들을 넣으면 편할 것 같다!
 *  - 충전소가 여러 개 겹치는 경우, 사용자는 결국 2명이니 같은 범위 내에 존재하더라도 상위 2개의 값만 비교하면 될 것 같다!
 */

import java.io.*;
import java.util.*;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int m, a, Ar, Ac, Br, Bc;
	static int[] A, B;
	static int[][][] map;
	static int[][] BC;
	static final int[] dr = new int[] { 0, -1, 0, 1, 0 };
	static final int[] dc = new int[] { 0, 0, 1, 0, -1 };

	static boolean isIn(int x, int y) {
		return 0 < x && x < 11 && 0 < y && y < 11;
	}

	/*
	 * 3. 현재 좌표에서의 충전량 최댓값 계산
	 *  - 충전 범위가 겹칠 경우를 대비해 상위 2개의 범위만 받아왔습니다.
	 *  - 충전 범위가 겹치면서, 플레이어가 같은 범위에 존재할 경우 최댓값을 뽑아야 하므로 2개만 추출했습니다.
	 */
	static int charger(int ar, int ac, int br, int bc) {
		// 플레이어 위치의 충전범위 탑 2 추출
		int[] A2 = top2(ar, ac);
		int[] B2 = top2(br, bc);

		/*
		 * 5. 얻어낸 충전량으로 a와 b의 좌표를 비교하며 충전량 업데이트
		 */
		int best = 0;
		int[] aId = {A2[0], A2[2]}; // A의 최대 충전량 충전기 아이디, 2번째로 높은 충전기 아이디
		int[] aP = {A2[1], A2[3]}; // A의 최대 충전량, 2번째로 높은 충전량
		int[] bId = {B2[0], B2[2]}; // B의 최대 충전량 충전기 아이디, 2번째로 높은 충전기 아이디
		int[] bP = {B2[1], B2[3]}; // B의 최대 충전량, 2번째로 높은 충전량
		
		// 각 id를 이용하여 값 선정
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				int aIdValue = aId[i], bIdValue = bId[j];
				int aPValue = aP[i], bPValue = bP[j];
				
				// 충전량의 합
				int sum = 0;
				if (aIdValue == 0 && bIdValue == 0) { // 충전기가 존재하지 않는다면
					continue; // pass
				}
				else if (aIdValue == bIdValue) { // 충전소가 겹친다면 절반만 들어가므로
					sum = aPValue; // 값 하나만 추가
				}
				else { // 충전소가 겹치지 않는다면 2개의 값 모두 추가
					sum = aPValue + bPValue;
				}
				if (sum > best) { // 현재 값이 저장된 최댓값보다 크다면
					best = sum; // 업데이트
				}
			}
		}
		
		return best;
	}

	/*
	 * 4. 현재 좌표에서 상위 2개의 충전 범위 추출
	 */
	static int[] top2(int r, int c) {
		int topId = 0, topP = 0; // 가장 높은 충전량
		int secondId = 0, secondP = 0; // 2번째로 높은 충전량

		for (int id = 1; id <= a; id++) { // a개의 BC가 있으므로 모두 탐색
			int p = map[r][c][id];
			if (p > topP) { // 현재 충전기의 충전량이 여태까지의 충전기의 최대 충전량보다 클 경우
				secondId = topId;
				secondP = topP;
				topId = id;
				topP = p;
			} else if (p > secondP) { // 2번째 충전기보다 충전량이 강할 경우
				secondId = id;
				secondP = p;
			}
		}

		return new int[] { topId, topP, secondId, secondP };
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			/*
			 * 1. 입력 받기
			 *  - A의 이동 경로
			 *  - B의 이동 경로
			 *  - BC 정보
			 */
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken()); // 이동 시간
			a = Integer.parseInt(st.nextToken()); // BC의 개수

			// A의 이동 경로
			st = new StringTokenizer(br.readLine());
			A = new int[m+1];
			A[0] = 0;
			for (int i = 1; i <= m; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			// B의 이동 경로
			st = new StringTokenizer(br.readLine());
			B = new int[m+1];
			B[0] = 0;
			for (int i = 1; i <= m; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			// BC 정보
			map = new int[11][11][a + 1]; // 지도 초기화
			for (int id = 1; id <= a; id++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				
				// 충전 범위 설정
				for (int dx = -C; dx <= C; dx++) {
					int col = C - Math.abs(dx);
					for (int dy = -col; dy <= col; dy++) {
						int nx = x + dx;
						int ny = y + dy;

						if (isIn(nx, ny)) {
							map[nx][ny][id] = P;
						}
					}
				}
			}
			
			/*
			 * 2. A와 B가 이동하며 충전량의 최댓값 계산
			 */
			Ar = 1; Ac = 1; // A의 시작 좌표
			Br = 10; Bc = 10; // B의 시작 좌표

			int total = 0; // 충전량 총합
			for (int i = 0; i <= m; i++) {
				Ar += dr[A[i]];
				Ac += dc[A[i]];
				Br += dr[B[i]];
				Bc += dc[B[i]];
				
				total += charger(Ar, Ac, Br, Bc); // 현재 좌표에서의 충전량 계산
			}
			sb.append("#" + tc + " " + total + "\n");
		}
		System.out.println(sb);
	}
}
