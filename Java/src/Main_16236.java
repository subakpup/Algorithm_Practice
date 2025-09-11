/*
 * Main_16236 아기 상어 (골드 3)
 *  - 메모리: 12548
 *  - 시간: 72
 *  
 * # 문제 정리
 *  - N*N 크기 공간
 *  - 물고기 M마리와 아기 상어 1마리 존재
 *  - 한 칸에는 물고기 최대 1마리 존재
 *  * 아기 상어는 
 *    - 자신 보다 큰 물고기는 지나칠 수 없고, 나머지 칸은 이동 가능
 *    - 자신 보다 작은 물고기만 먹을 수 있다.
 *  * 아기 상어의 이동 결정
 *    - 먹을 수 있는 물고기가 없다면 아기 상어는 엄마 상어에게 도움 요청
 *    - 먹을 수 있는 물고기가 1마리라면 먹으러 간다.
 *    - 먹을 수 있는 물고기가 여러 마리라면, 거리가 가장 가까운 물고기를 먹으러 간다
 *      - 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때 지나야하는 칸의 개수의 최솟값
 *      - 거리가 가까운 물고기가 많다면, 가장 위, 그러한 물고기가 많다면, 가장 왼쪽에 있는 물고기를 먹는다.
 *  - 아기 상어의 이동은 1초
 *  - 이동과 동시에 물고기를 먹으면 그 칸은 빈 칸이 된다.
 *  - 아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때마다 크기 증가
 *    ex) 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 됨
 *  
 *  >> 아기 상어가 몇 초 동안 엄마 상어에게 도움을 청하지 않고 물고기를 잡아먹을 수 있는가?
 * 
 * # 아이디어
 *  - BFS를 통해 먹을 수 있는 물고기 탐색
 *  - while문을 통해 먹을 수 있는 물고기가 사라질 때까지 진행
 *  
 */

import java.util.*;
import java.io.*;

public class Main_16236 {
	static int n; // 한 변의 길이
	static int[][] map; // 지도 정보
	static int sr, sc; // 시작 좌표
	
	static int shark = 2; // 아기 상어 크기
	static int eat = 0; // 지금까지 먹은 물고기의 수
	static int time = 0; // 걸린 시간
	
	// 4방 탐색 (위쪽과 왼쪽 탐색을 먼저 진행)
	static final int[] dr = { -1, 0, 0, 1 };
	static final int[] dc = { 0, -1, 1, 0 };
	
	// 아기 상어가 먹을 물고기
	static class Target {
		int r, c, dist;
		
		Target (int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	
	// 물고기 사냥 시작
	private static void simulate() {
		while (true) {
			Target t = bfs(); // 아기 상어가 먹을 물고기의 정보
			if (t == null) return; // 없다면 return
			
			time += t.dist; // 이동한 거리만큼 시간 증가
			map[t.r][t.c]= 0; // 잡아먹은 물고기 빈 칸으로 변환
			sr = t.r; sc = t.c; // 시작 좌표 갱신
			if (++eat == shark) { // 먹은 횟수 + 1한 값이 상어의 크기와 같다면
				eat = 0; // 먹은 횟수 초기화
				++shark; // 상어 크기 증가
			}
		}
	}
	
	private static Target bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { sr, sc }); // 시작 좌표 삽입
		int[][] dist = new int[n][n]; // 거리를 저장할 배열 선언
		for (int i = 0; i < n; i++) Arrays.fill(dist[i], -1); // -1로 초기화
		dist[sr][sc] = 0; // 현재 좌표 0으로 초기화
		
		int tDist = Integer.MAX_VALUE; // 물고기까지의 거리
		int tr = -1, tc = -1; // 물고기의 좌표
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1];
			
			if (dist[r][c] > tDist) continue; // 현재 잡아먹을 물고기보다 멀리 있다면 안 봐도 됨
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				// 범위 밖 or 이미 방문한 좌표 or 상어보다 크다면 pass
				if (nr < 0 || nr >= n || nc < 0 || nc >= n || dist[nr][nc] != -1 || map[nr][nc] > shark) continue;
				
				dist[nr][nc] = dist[r][c] + 1; // 다음 좌표 거리 증가
				
				// 나보다 작은 물고기를 만났을 때
				if (map[nr][nc] != 0 && map[nr][nc] < shark) {
					if (dist[nr][nc] < tDist) { // 현재 타겟의 거리보다 짧을 경우: 거리, 좌표 갱신
						tDist = dist[nr][nc];
						tr = nr; tc = nc;
					} else if (dist[nr][nc] == tDist){ // 현재 타겟과 같은 거리일 경우: 위쪽, 같은 행이라면 왼쪽 물고기로 갱신
						if (tr > nr || (tr == nr && tc > nc)) {
							tr = nr; tc = nc;
						}
					}
				} else { // 이동할 수 있는 칸인 경우
					queue.add(new int[] {nr, nc});
				}

			}
		}
		
		// 먹을 물고기가 없다면 null, 아니라면 잡아먹을 물고기의 정보 return
		return (tr == -1 || tc == -1 || tDist == Integer.MAX_VALUE) ? null : new Target(tr, tc, tDist);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 9) {
					map[i][j] = 0;
					sr = i; sc = j;
					continue;
				}
				map[i][j] = a;
			}
		}
		
		simulate();
		System.out.println(time);
	}
}
