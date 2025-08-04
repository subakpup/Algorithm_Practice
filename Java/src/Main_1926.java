import java.util.*;
import java.io.*;

public class Main_1926 {
	// 클래스 변수 선언
	static int n, m; // 도화지 넓이
	static int area, cnt, answer; // 그림의 넓이, 그림의 갯수, 가장 큰 그림의 넓이
	static int[][] arr; // 도화지
	static boolean[][] visited; // 방문 여부
	
	// 해당 좌표가 도화지의 크기를 벗어나지 않는지 확인하는 메서드
	public static boolean isIn(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}
	
	// 그림의 크기를 탐색하는 메서드
	public static int bfs(int X, int Y) {
		// 4방 탐색할 좌표
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		// 색이 칠해진 넓이
		area = 1;
		
		// Queue를 이용하여 탐색
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {X, Y}); // 시작 노드값 삽입
		visited[X][Y] = true; // 방문 처리
		
		// queue에 값이 없을 때까지 반복
		while (!queue.isEmpty()) {
			int[] p = queue.poll(); // 시작 노드 추출
			int x = p[0];
			int y = p[1];
			
			// 4방 탐색
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				/** 다음 조건일 경우 탐색 시작
				 * 1) 탐색할 값이 범위 내에 있으며
				 * 2) 색이 칠해져 있으며(1)
				 * 3) 방문하지 않았을 경우
				 */
				if (isIn(nx,ny) && arr[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true; // 방문 처리
					queue.offer(new int[] {nx, ny}); // queue에 값 추가
					area += 1; // 넓이 + 1
				}
			}
		}
		
		// 탐색이 종료되면 그림의 넓이 리턴
		return area;
	}
	
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 도화지에 값 추가
		// N*M
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 방문 여부
		visited = new boolean[n][m];
		
		// 탐색 시작
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) { // 색칠해진 구역이면서 방문하지 않은 구역일 경우 탐색 시작
					answer = Math.max(answer, bfs(i,j)); // 정답 업데이트
					cnt += 1; // 그림의 갯수 카운팅
				}
			}
		}
		
		// 정답 출력
		System.out.println(cnt);
		System.out.println(answer);
		
	}

}
