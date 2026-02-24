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
	
	static final int INF = 1_000_000_000;
	static final int[] dr = { -1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1 };
	static final int[] dc = { 0, 0, -1, 1, -2, -1, 1, 2, -2, -1, 1, 2 };
	
	private static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { 0, 0, 0 });
		
		int[][][] dist = new int[h][w][k+1];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				Arrays.fill(dist[i][j], INF);
			}
		}

		dist[0][0][0] = 0;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1], jump = cur[2];
			
			for (int i = 0; i < 12; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				int nextJump = (i > 3) ? jump + 1 : jump;
				
				if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
				if (nextJump > k || map[nr][nc] == 1 || dist[nr][nc][nextJump] != INF) continue;
				
				dist[nr][nc][nextJump] = dist[r][c][jump] + 1;
				queue.add(new int[] { nr, nc, nextJump });
			}
		}
		
		int answer = INF;
		for (int i = 0; i <= k; i++) answer = Math.min(answer, dist[h-1][w-1][i]);
		
		return answer == INF ? -1 : answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
	}

}

