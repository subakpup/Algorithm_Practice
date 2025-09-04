/*
 * Main_1600 말이 되고픈 원숭이 (골드 3)
 *  - 메모리: 61972
 *  - 시간: 448
 *  
 * # 문제 정리
 *  - 원숭이가 말처럼 뛰어서 이동하고 싶어한다.
 *  - 총 K번만 이동 가능
 *  - 나머지는 인접한 칸으로 이동할 수 있다. (4방)
 *  - 맨 왼쪽 위에서 맨 오른쪽 아래까지 가야 한다.
 *  - 원숭이가 최소한의 동작으로 시작지점에서 도착지점까지 갈 수 있는 횟수 출력
 *  
 * # 아이디어
 *  - BFS로 원숭이가 이동할 수 있는 방향으로 모두 이동
 *  - 최솟값을 비교해 이동 시킨다.
 *  - 메모이제이션 활용
 *  - 3차원 배열에 점프 횟수를 저장해놓자
 */

import java.util.*;
import java.io.*;

public class Main_1600 {
	static int k, w, h;
	static int[][] map;

	// 4방 + 말의 이동 위치
	static final int[] dr = { -1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1 };
	static final int[] dc = { 0, 0, -1, 1, -2, -1, 1, 2, 2, 1, -1, -2 };

	private static int bfs(int sr, int sc) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { sr, sc, k }); // 좌표, 남은 점프 횟수

		// 이동횟수를 저장할 배열 (최솟값 갱신을 위해 최댓값으로 초기화)
		int[][][] visited = new int[h][w][k+1];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
			}
		}
		visited[sr][sc][k] = 0; // 현재 좌표 (이동 횟수 0)

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1], jump = cur[2];

			for (int i = 0; i < 12; i++) {
				if (jump <= 0 && i >= 4) break; // 말 이동을 하려는데 jump 횟수가 남지 않았을 경우 종료
				
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= h || nc < 0 || nc >= w || map[nr][nc] == 1) continue;
				
				int nextJump = (i >= 4) ? (jump - 1) : jump; // 말 이동을 할 때는 jump - 1, 아니라면 그대로 갖고 감
				
				if (visited[nr][nc][nextJump] > visited[r][c][jump] + 1) {
					visited[nr][nc][nextJump] = visited[r][c][jump] + 1;
					queue.add(new int[] {nr, nc, nextJump});
				}
				
			}
		}
		
		// 정답 리턴
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i <= k; i++) answer = Math.min(answer, visited[h-1][w-1][i]);
		if (answer == Integer.MAX_VALUE) answer = -1;
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken()); // 열
		h = Integer.parseInt(st.nextToken()); // 행

		// 지도 초기화
		map = new int[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs(0, 0));

	}

}
