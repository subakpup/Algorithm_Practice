
/*
 * Solution_5656 벽돌 깨기
 * 
 * # 문제 정리
 *  - 구슬을 쏘아 벽돌을 깨트리는 게임
 *  - 구슬은 N번만 쏠 수 있음
 *  - 벽돌의 정보: W*H (0은 빈 공간)
 *  1. 구슬은 좌우만 이동 가능
 *   => 맨 위 벽돌만 깰 수 있음
 *  2. 벽돌: 1~9로 이루어짐
 *   * 명중한 벽돌은 상하좌우 (벽돌 숫자 - 1)만큼 제거
 *  3. 제거되는 벽돌은 동시에 제거
 *  4. 빈 공간이 생길 경우 벽돌은 아래로 내려감
 *  - N개의 구슬을 이용해 최대한 많은 벽돌 제거
 *  
 * # 아이디어
 *  - 백트래킹을 이용해 중복 조합을 생성하자
 *  - 조합의 좌표들에 구슬 발사
 *  - 벽돌에 부딪힌다면 4방으로 폭발
 *   - 연쇄적으로 하기 위해 다음 좌표도 폭발(재귀)
 *  - 폭발 후에 벽돌을 바닥으로 내림
 *  - 남아있는 벽돌 수를 체킹해 최솟값이라면 정답값 업데이트
 */

import java.util.*;
import java.io.*;

public class Solution_5656 {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, w, h, answer;
	static int[] pick;
	static int[][] data, map;
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };

	// 중복 조합
	// n개 선택했다면 구슬 발사
	private static void dfs(int depth) {
		if (depth == n) {
			
			blockIni(); // 초기 상태로 초기화
			
			for (int i = 0; i < n; i++) {
				bombCheck(pick[i]); // 조합의 좌표에서 구슬 발사
				gravity(); // 폭발 후 아래로 내리기
			}
			
			int tmp = blockCheck(); // 남아있는 벽돌의 개수
			if (tmp < answer) {
				answer = tmp; // 업데이트
//				test(); // 디버깅
			}
			return;
		}

		// 재귀를 이용한 중복 순열
		for (int c = 0; c < w; c++) {
			pick[depth] = c;
			dfs(depth + 1);
		}
	}
	

	// 벽돌 초기화
	private static void blockIni() {
		map = new int[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				map[i][j] = data[i][j];
			}
		}
	}

	// 폭발이 가능한 좌표인가 확인하는 메서드
	private static void bombCheck(int c) {
		int r = 0;
		while (r < h && map[r][c] == 0) r++;
		if (r == h) return; // 바닥에 닿았다면 벽돌이 없다는 것이므로 return

		bomb(r, c);
	}

	private static void bomb(int r, int c) {
		int power = map[r][c]; // 벽돌의 숫자(폭발 범위)
		
		map[r][c] = 0; // 현재 좌표부터 삭제
		
		if (power == 1) return; // 1이라면 본인만 폭발하고 끝나므로 return
		
		for (int d = 0; d < 4; d++) { // 4방향
			for (int i = 1; i < power; i++) { // 폭발 범위만큼
				int nr = r + dr[d] * i;
				int nc = c + dc[d] * i;

				if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue; // 범위를 벗어난다면 다음 좌표 탐색

				if (map[nr][nc] == 0) continue; // 0이라면 지나침
				
				bomb(nr, nc); // 숫자라면 재귀
			}
		}
	}

	// 벽돌을 아래로 내리는 메서드
	private static void gravity() {
		for (int c = 0; c < w; c++) {
			int line = h - 1; // 가장 아래
			for (int r = h - 1; r >= 0; r--) { // 아래부터 탐색하며 올라옴
				if (map[r][c] != 0) { // 블록이 존재한다면
					// 위치 swap
					int tmp = map[r][c];
					map[r][c] = 0;
					map[line][c] = tmp;
					line--;
				}
			}
		}
	}

	// 블록의 개수를 세는 메서드
	private static int blockCheck() {
		int tmp = 0;
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j] != 0) tmp++;
			}
		}
		
		return tmp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 구슬의 개수
			w = Integer.parseInt(st.nextToken()); // 너비
			h = Integer.parseInt(st.nextToken()); // 높이

			data = new int[h][w]; // 벽돌 원본
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = Integer.MAX_VALUE;
			pick = new int[n]; // 조합을 저장할 배열
			dfs(0);
			
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void test() {
		System.out.println("===================");
		for (int[] line : map) {
			for (int v : line)
				System.out.print(v + " ");
			System.out.println();
		}
	}
}
