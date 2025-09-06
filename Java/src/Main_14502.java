/*
 * Main_14502 연구소 (골드 4)
 *  - 메모리: 295192
 *  - 시간: 720
 *  
 * # 문제 정리
 *  - N*M 연구소
 *   - 빈 칸, 벽, 바이러스
 *   - 바이러스는 상하좌우로 퍼짐
 *   - 새로 세울 수 있는 벽의 개수는 3개
 *  - 얻을 수 있는 안전 영역의 크기의 최댓값 출력
 *  
 * # 아이디어
 *  - 바이러스 주변으로 벽을 3개씩 쌓고
 *  - 바이러스를 퍼트리자
 *  - 그러고 안전 영역의 개수 찾기
 * 
 */
import java.util.*;
import java.io.*;

public class Main_14502 {
	static int n, m;
	static int answer = 0;
	static int[][] map;
	static List<int[]> virus;
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	/*
	 * 벽 만드는 메서드
	 */
	private static void makeWall(int cnt) {
		if (cnt == 3) { // 벽을 3개 쌓았다면 바이러스 퍼트리기
			bfs();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) { // 빈 공간이라면
					map[i][j] = 1; // 벽 만들고
					makeWall(cnt + 1); // 다음 벽 세우기
					map[i][j] = 0; // 백트래킹
				}
			}
		}
	}
	
	/*
	 * 바이러스를 퍼트리는 메서드
	 */
	private static void bfs() {
		// 원본은 건드리지 않고 바이러스 퍼트리기
		int[][] tmp = new int[n][m];
		for (int i = 0; i < n; i++) tmp[i] = map[i].clone();
		
		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i < virus.size(); i++) {
			queue.add(virus.get(i));
		}
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m || tmp[nr][nc] != 0) continue;
				
				tmp[nr][nc] = 2;
				queue.add(new int[] {nr, nc});
			}
		}
		
		count(tmp);
	}
	
	/*
	 * 안전 영역을 세는 메서드
	 */
	private static void count(int[][] tmp) {
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tmp[i][j] == 0) cnt++;
			}
		}
		
		if (cnt > answer) answer = cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 세로
		m = Integer.parseInt(st.nextToken()); // 가로
		
		// 지도 초기화
		map = new int[n][m];
		virus = new ArrayList<>(); // 바이러스가 퍼질 위치
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)	virus.add(new int[] {i, j});
			}
		}
		
		makeWall(0);
		
		System.out.println(answer);
	}
}
