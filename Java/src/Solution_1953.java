/*
 * Solution_1953 탈주범 검거
 * 
 * # 문제 정리
 *  - 터널끼리 연결 되어 있는 경우 이동이 가능하므로 탈주범이 있을 수 있는 위치의 개수를 계산
 *  - 탈주범은 시간당 1의 거리를 움직일 수 있다.
 *  - 7개의 파이프가 있다.
 *   1. 상, 하, 좌, 우 연결된 터널
 *   2. 상, 하 연결된 터널
 *   3. 좌, 우
 *   4. 상, 우
 *   5. 하, 우
 *   6. 하, 좌
 *   7. 상, 좌
 *  - 지하 터널 지도, 맨홀 뚜껑 위치, 경과된 시간이 주어질 때, 탈주범이 위치할 수 있는 장소의 개수 출력
 *  
 * # 아이디어
 *  - BFS 탐색을 이용해 해당 깊이까지 검사를 하자
 *  
 */
import java.io.*;
import java.util.*;

public class Solution_1953 {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, m, r, c, l;
	static int[][] map;
	static boolean[][] visited;
	static final int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상, 하, 좌, 우 탐색
	static final int[][] pipe = new int[][] { 
		{},
		{ 0, 1, 2, 3 },	// 상, 하, 좌, 우
		{ 0, 1 }, 		// 상, 하
		{ 2, 3 },		// 좌, 우
		{ 0, 3 },		// 상, 우
		{ 1, 3 },		// 하, 우
		{ 1, 2 },		// 하, 좌
		{ 0, 2 }		// 상, 좌
	};
	static final int[] opp = new int[] { 1, 0, 3, 2 };

	private static int bfs() {
		visited = new boolean[n][m]; // 방문 여부
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { r, c, 1 }); // (r, c) 좌표, 소요된 시간
		visited[r][c] = true; // 방문 처리
		int cnt = 1; // 확인 가능한 장소

		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			int x = p[0];
			int y = p[1];
			int t = p[2];

			if (t >= l) continue; // 소요 시간이 지났을 경우 pass

			int cur = map[x][y]; // 현재 좌표
			for (int i : pipe[cur]) {
				int nr = x + dir[i][0]; // 파이프를 타고 이동한 다음 좌표
				int nc = y + dir[i][1];

				if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) continue;

				int next = map[nr][nc]; // 다음 좌표
				if (next == 0) continue; // 터널이 없으면 이동 X
				
				// 반대편 터널이 열려있는지 확인하는 메서드
				boolean ok = false;
				for (int v : pipe[next]) {
					if (v == opp[i]) { // 반대편이 열려있다면
						ok = true;
						break;
					}
				}
				if (!ok) continue; // 반대편이 닫혀 있다면 pass

				queue.add(new int[] { nr, nc, t + 1 }); // 다음 좌표, 시간 + 1
				visited[nr][nc] = true; // 방문 처리
				cnt++; // 탐색 가능한 공간 + 1
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 지도 세로
			m = Integer.parseInt(st.nextToken()); // 지도 가로
			r = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 좌표 r
			c = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 좌표 c
			l = Integer.parseInt(st.nextToken()); // 소요된 시간

			/*
			 * 지도 초기화
			 */
			map = new int[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int answer = bfs();
			sb.append("#" + tc + " " + answer + "\n");

		}
		System.out.println(sb);
	}
}
