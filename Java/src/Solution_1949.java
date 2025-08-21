/*
 * Solution_1949 등산로 조성
 * 
 * # 문제 정리
 *  - N*N 부지
 *  - 최대한 긴 등산로 출력
 *  - 지도에는 높이가 주어짐
 *   1. 가장 높은 숫자부터 시작
 *   2. 높은 지형 -> 낮은 지형
 *   3. 가로 또는 세로로만 길을 만들 수 있음
 *   4. 딱 한 곳을 정해서 최대 K만큼 지형 깎기 가능
 *   
 * # 아이디어
 *  - DFS를 활용해 이동할 수 있는 경로를 전부 탐색해보자 !
 *  
 */
import java.io.*;
import java.util.*;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, k, max_height, answer;
	static int[][] map;
	static boolean[][] visited;
	static final int[] dr = new int[] { -1, 1, 0, 0 };
	static final int[] dc = new int[] { 0, 0, -1, 1 };

	/*
	 * 등산로 탐색 메서드
	 */
	private static void dfs(int r, int c, int dist, boolean used) { // 좌표 r, c, 길이, 지형 깎기 여부

		if (answer < dist) answer = dist; // 길이 갱신
		
		visited[r][c] = true; // 방문 처리
		
		for (int i = 0; i < 4; i++) {
			// 다음 좌표
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (isIn(nr, nc) && !visited[nr][nc]) { // 범위 내 && 방문하지 않은 좌표
				if (map[r][c] > map[nr][nc]) { // 값이 더 작을 경우 길이 늘려가며 진행
					dfs(nr, nc, dist + 1, used);
				}
				else if (map[r][c] > map[nr][nc] - k && !used) { // 깎아서 진행할 수 있으면 진행
					int tmp = map[nr][nc]; // 깎기 전 높이 임시 저장
					map[nr][nc] = map[r][c] - 1; // 높이 1 깎기
					dfs(nr, nc, dist + 1, true); // 다음 등산로 탐색
					map[nr][nc] = tmp; // 백트래킹
				}
			}
		}
		
		visited[r][c] = false; // 백트래킹

	}

	/*
	 * 좌표가 범위 내에 있는지 확인하는 메서드
	 */
	private static boolean isIn(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 등산로 한 변의 길이
			k = Integer.parseInt(st.nextToken()); // 깎을 수 있는 땅의 깊이

			/*
			 * 지도 설정
			 */
			map = new int[n][n];
			max_height = 0; // 최대 높이(시작점) 
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (max_height < map[i][j]) {
						max_height = map[i][j]; // 최댓값 갱신
					}
				}
			}

			/*
			 * 최대 높이에서 탐색 시작
			 */
			visited = new boolean[n][n];
			answer = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == max_height) {
						dfs(i, j, 1, false);
					}
				}
			}
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb);
	}
}
