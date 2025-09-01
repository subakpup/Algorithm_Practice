/*
 * Main_16930 달리기 (플래티넘 3)
 *  - 메모리: 56032
 *  - 시간: 356
 *  
 * # 문제 정리
 *  - N*M 크기 체육관
 *  - 각 칸은 빈 칸 또는 벽
 *  - 상, 하, 좌, 우 이동할 방향을 하나 고르고
 *  - 그 방향으로 최소 1개, 최대 K개의 빈 칸 이동 가능
 *  - 시작점과 도착점이 주어졌을 때, 최소 시간 출력
 *  
 * # 아이디어
 *  - BFS로 풉시다. 근데 DP를 곁들인
 *  - 메모이제이션을 활용해 이동할 수 있는 좌표에 해당 값을 다 넣어 줍니다.
 *  - 최적화를 열심히 합시다..
 *  - 통곡의 96퍼에서 못 넘기다가 최적화 열심히 하니 통과가 되더군요..
 *  
 */

import java.util.*;
import java.io.*;

public class Main {
	static int n, m, k, sr, sc, er, ec;
	static int answer = -1;
	static char[][] map;
	static int[][] dist;
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };

	private static void bfs(int sr, int sc) {
		dist = new int[n][m]; // 이동한 횟수를 저장할 배열
		for (int[] line : dist) Arrays.fill(line, Integer.MAX_VALUE); // 최솟값 갱신을 위해 MAX_VALUE로 초기화
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { sr, sc }); // 시작 좌표 큐에 삽입
		dist[sr][sc] = 0; // 시작 좌표의 이동 횟수는 0으로 초기화

		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			int r = p[0];
			int c = p[1];
			
			// 좌표가 도착 지점이라면 리턴
			if (r == er && c == ec) {
				answer = dist[r][c];
				return;
			}

			int tmp = dist[r][c] + 1; // 다음 좌표에 넣을 값(이전까지의 이동횟수 + 1)

			for (int i = 0; i < 4; i++) {
				for (int j = 1; j <= k; j++) {
					int nr = r + dr[i] * j; // 이동할 수 있는 좌표 전체
					int nc = c + dc[i] * j;

					// 범위 밖이라면 continue
					if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
					
					// 이동할 수 없거나, 이전 좌표보다 이동횟수가 많을 경우 종료
					if (map[nr][nc] == '#' || dist[nr][nc] < tmp) break;
					
					// 같은 비용으로 이미 방문 예정 -> 이번 칸은 스킵
					if (dist[nr][nc] == tmp) continue;
					
					// 더 좋은 거리가 있다면 갱신 및 큐 삽입
					dist[nr][nc] = tmp;
					queue.add(new int[] { nr, nc });
					
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 세로
		m = Integer.parseInt(st.nextToken()); // 가로
		k = Integer.parseInt(st.nextToken()); // 이동할 수 있는 최대 거리

		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken()) - 1; // 시작 좌표 x
		sc = Integer.parseInt(st.nextToken()) - 1; // 시작 좌표 y
		er = Integer.parseInt(st.nextToken()) - 1; // 도착 좌표 x
		ec = Integer.parseInt(st.nextToken()) - 1; // 도착 좌표 y

		bfs(sr, sc);

		System.out.println(answer);
	}

}
