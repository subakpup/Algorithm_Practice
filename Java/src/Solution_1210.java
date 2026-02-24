/*
 * Solution_1210 Ladder1 (D4)
 * 
 * # 문제 정리
 *  - 어느 사다리를 고르면 X표시에 도착하는가
 *  - 10개의 테스트 케이스가 주어지고, 각 첫 줄에는 테스트케이스 번호가 입력된다..
 * 
 * # 아이디어
 *  - 도착지점부터 시작해서 올라가면 금방 구할 수 있을 것 같다!
 *  - bfs를 이용해서 3방향(아래는 고려하지 않아도 되기 때문) 탐색
 *  - 좌우 먼저 살핀 후 길이 없으면 올라가자
 *  - 길이 있다면 이동하고 다음 탐색은 X
 */

import java.util.*;
import java.io.*;

public class Solution_1210 {
	static StringBuilder sb = new StringBuilder();
	static int[][] board; // 사다리 지도
	static int[] dx = new int[] {0, 0, -1}; // 탐색할 행
	static int[] dy = new int[] {-1, 1, 0}; // 탐색할 열
	static int target; // 도착지점(2)
	static int answer; // 출발지점
	static boolean[][] visited; // 방문 여부
	
	public static void bfs(int X, int Y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {X, Y}); // 도착 지점의 좌표 삽입
		// 1인 구역만 탐색할 것이기 때문에 2인 도착 지점은 방문 처리 안 해도 됨
		
		while (!queue.isEmpty()) {
			int[] p = queue.poll(); // 좌표 추출
			int x = p[0];
			int y = p[1];
			
			if (x == 0) { // 시작 지점 행일 경우 종료
				answer = y;
				return;
			}
			
			for (int i = 0; i < 3; i++) { // 상, 좌, 우 3방향 탐색
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				// 좌표 내에 있으며, 탐색하려는 좌표의 값이 1이며, 방문하지 않았을 경우 탐색
				if (isIn(nx, ny) && board[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[]{nx, ny});
					break; // 방향은 한 곳으로만 탐색해야하기 때문에, 길이 정해지면 break;
				}
				
			}
		}
		
	}
	
	// 좌표 내에 존재하는지 검사하는 메서드
	public static boolean isIn(int x, int y) {
		return 0 <= x && x < 100 && 0 <= y && y < 100;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(br.readLine()).append(" "); // 테스트 케이스 번호
			
			// 사다리 그림 그리기
			board = new int[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 도착 좌표 찾기
			target = -1;
			for (int i = 0; i < 100; i++) {
				if (board[99][i] == 2) target = i; // 마지막 줄만 탐색하여 도착 지점(2) 탐색
			}
			
			// 정답, 방문 여부 초기화
			answer = 0;
			visited = new boolean[100][100];
			bfs(99, target); // 마지막 줄부터 탐색 시작
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
