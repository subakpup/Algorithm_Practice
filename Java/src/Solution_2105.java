/*
 * Solution_2105 디저트 카페
 * 
 * # 문제 정리
 *  - 한 변의 길이가 N인 정사각형 모양을 가진 지역
 *  - 각 칸의 숫자는 디저트의 종류
 *  - 카페 투어는 한 카페에서 출발하여
 *    "대각선 방향으로 움직이고 사각형 모양을 그리며 출발한 카페로 돌아와야 한다."
 *  - 해당 지역을 벗어나면 안 됨
 *  - 카페 투어 중 같은 숫자의 디저트를 팔고 있는 카페가 있으면 안 된다.
 *  - 하나의 카페만 방문 X
 *  - 왔던 길을 다시 돌아가는 것도 안 된다.
 *  - 디저트를 가장 많이 먹을 수 있는 경로를 찾고, 디저트 수를 정답으로 출력
 *  
 * # 아이디어
 *  - N은 4 이상 20 이하 !
 *  - N^2의 범위를 모두 순회하자(변의 길이 4N만큼 돈다 가정했을 때 O(N^3)이다. 시간초과 안 남)
 *  - (0,0)부터 (n-1,n-1)까지 전부 순회할 것이다.
 *  - 순회하는 공간은 직사각형이다. 즉, 4변 중 마주보고 있는 변들의 길이가 같다.
 *  - 최소 1부터 n-1까지 각 변을 순회해주고 기저조건을 설정하여 다시 돌아왔을 경우 정답을 리턴하자 !
 *  
 */

import java.util.*;
import java.io.*;

public class Solution_2105 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[][] map;
	static boolean[] visited;
	static final int[][] dir = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

	/*
	 * 맵의 모든 좌표 탐색
	 * - 각 변의 길이 a, b로 설정
	 */
	private static int func() {
		int answer = -1;

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				// 변의 길이는 1부터 n-1까지 가능함
				for (int a = 1; a < n; a++) {
					for (int b = 1; b < n; b++) {
						int tmp = simulate(r, c, a, b);
						if (tmp > answer) answer = tmp;
					}
				}
			}
		}

		return answer;
	}

	private static int simulate(int r, int c, int a, int b) {
		if (c + a >= n) return -1; // 오른쪽 범위 초과
		if (r + a + b >= n) return -1; // 아래 범위 초과
		if (c - b < 0) return -1; // 왼쪽 범위 초과

		// 방문 여부
		visited = new boolean[101];
		int nr = r, nc = c; // 변의 길이를 계속 늘려줘야 하므로 파라미터를 지역 변수로 새로 할당
		visited[map[nr][nc]] = true; // 방문 처리
		int cnt = 1; // 카페의 수
		
		int[] steps = { a, b, a, b }; // 탐색할 변의 길이(오른쪽 아래, 왼쪽 아래, 왼쪽 위, 오른쪽 위 순서)
		for (int d = 0; d < 4; d++) { // 4변 탐색
			for (int s = 1; s <= steps[d]; s++) { // 변의 길이 1부터 a || b 까지 탐색
				nr += dir[d][0];
				nc += dir[d][1];

				// 범위를 벗어날 경우 마름모를 못 이룸
				if (nr < 0 || nr >= n || nc < 0 || nc >= n) return -1;

				// 마지막 좌표가 처음 좌표와 일치할 경우 카페의 수 리턴
				if (d == 3 && s == steps[3] && r == nr && c == nc) return cnt;

				// 겹치는 카페가 존재한다면 return
				if (visited[map[nr][nc]]) return -1;
				
				// 범위 내 && 마지막 좌표가 아님 && 현재까지 겹치는 카페가 없을 경우
				visited[map[nr][nc]] = true; // 방문 처리
				cnt++; // 카페 수 + 1
			}
		}
		
		// 기저 조건에서 리턴하지 못했을 경우 -1 리턴
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine()); // 변의 길이
			
			// 맵 초기화
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append("#" + tc + " " + func() + "\n");
		}
		System.out.println(sb.toString());
	}

}
