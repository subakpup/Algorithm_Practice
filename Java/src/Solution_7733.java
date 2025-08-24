/*
 * Solution_7733 치즈 도둑 (D4)
 * 
 * # 문제 정리
 *  - N*N 사이즈의 치즈
 *  - 맛 정도: 1~100
 *  - 쥐가 n번째 날에 n인 칸을 먹음
 *  - 100일 중 치즈 덩어리가 가장 많을 때의 덩어리 개수
 *   - 덩어리는 치즈가 상하좌우로 인접한 경우 한 덩어리로 봄
 *   
 * # 아이디어
 *  - 쥐가 파먹지 않은 부분만 BFS를 실행한다면 덩어리 개수를 구할 수 있다.
 *  - 쥐가 파먹은 부분은 0으로 설정하면 좋겠다.
 */
import java.io.*;
import java.util.*;

public class Solution_7733 {
	static StringBuilder sb = new StringBuilder();
	static int n, block; // 치즈 한 변의 길이
	static int[][] cheese; // 치즈의 정보
	static boolean[][] visited; // 방문 여부
	static final int[] dx = new int[] {0, 0, 1, -1};
	static final int[] dy = new int[] {1, -1, 0, 0};
	
	/*
	 * 범위 내인지 확인하는 메서드
	 */
	private static boolean isIn(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}
	
	/*
	 * BFS 메서드
	 */
	private static void bfs(int X, int Y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {X, Y});
		visited[X][Y] = true;
		
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			int x = p[0];
			int y = p[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				// 범위 내 && 방문하지 않음 && 쥐가 파먹지 않은 부분
				if (isIn(nx, ny) && !visited[nx][ny] && cheese[nx][ny] != 0) {
					queue.add(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			// 치즈 한 변의 길이
			n = Integer.parseInt(br.readLine());
			
			// 치즈 선언
			cheese = new int[n][n];
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 0일부터 100일까지 모두 탐색
			block = 0;
			for (int day = 0; day <= 100; day++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (cheese[i][j] == day) { // 해당일에는 그 부분만 쥐가 파먹음
							cheese[i][j] = 0; // 0으로 처리
						}
					}
				}
				
				int tmp = 0; // 덩어리 개수를 저장할 임시 변수
				visited = new boolean[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (cheese[i][j] != 0 && !visited[i][j]) { // 쥐가 파먹지 않은 부분 && 방문하지 않은 부분
							bfs(i,j);
							tmp++; // 한 덩어리
						}
					}
				}
				
				// 최댓값 갱신
				if (block < tmp) {
					block = tmp;
				}
			}
			sb.append("#" + tc + " " + block + "\n");
		}
		System.out.println(sb);
	}
}
