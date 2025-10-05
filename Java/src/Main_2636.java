/*
 * Main_2636 치즈 (골드 4)
 *  - 메모리: 12832
 *  - 시간: 92
 *  
 * # 문제 정리
 *  - N*M 크기의 판
 *  - 치즈가 공기와 닿게 되면 겉면이 녹게 됨
 *   - 치즈 안에 있는 구멍 속에는 공기가 없으므로 녹지 않음!
 *  - 치즈가 모두 녹아내리는 데 걸리는 시간, 녹기 한 시간 전에 남아있는 치즈 조각의 수 출력
 *  
 * # 아이디어
 *  - 너무 어렵게 생각했었읍니다..
 *  - BFS로 탐색을 진행하는데, 치즈를 만났을 경우에 공기로 전환만 하고 큐에 넣지 않으면 치즈가 녹는 것이 주변으로 퍼지지 않습니다.
 *  
 */

import java.util.*;
import java.io.*;

public class Main_2636 {
	static int n, m;
	static int cheese, cnt, time;
	static int[][] map;
	
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	
	private static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0, 0}); // (0, 0)부터 시작
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true; // 방문 처리
		
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			int r = p[0], c = p[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				// 범위 밖 || 방문 했다면 pass
				if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) continue;
				
				visited[nr][nc] = true; // 방문 처리

				if (map[nr][nc] == 0) { // 공기일 경우 그냥 퍼져나감
					queue.offer(new int[] {nr, nc});
				} else { // 치즈일 경우
					cheese--; // 치즈 개수 - 1
					map[nr][nc] = 0; // 치즈 녹이기
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 행
		m = Integer.parseInt(st.nextToken()); // 열
		
		// 판 초기화
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) cheese++; // 치즈 조각
			}
		}
		
		cnt = 0; time = 0;
		while (cheese > 0) { // 치즈가 0이 될 때까지 진행
//			view();
			cnt = cheese; // 현재 치즈 조각의 개수
			time++; // 시간 증가
			bfs(); // 치즈 녹이기 시작
		}
		
		System.out.println(time + "\n" + cnt);
	}
	
//	private static void view() {
//		System.out.println();
//		for (int[] line : map) {
//			for (int v : line) System.out.print(v + " ");
//			System.out.println();
//		}
//	}
}
