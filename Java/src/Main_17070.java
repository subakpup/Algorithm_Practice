/*
 * Main_17070 파이프 옮기기 1 (골드 5)
 *  - 메모리: 13876
 *  - 시간: 164
 *  
 * # 문제 정리
 *  - 집의 크기 N*N
 *  - 파이프는 2개의 연속된 칸을 차지
 *  - 파이프의 회전 방향: 가로, 세로, 대각선
 *  - 파이프는 항상 빈 칸만을 차지
 *  - 파이프의 한 쪽 끝을 (N, N)으로 이동시키는 방법의 개수 출력
 *  
 * # 아이디어
 *  - DFS
 *  - 이동할 수 있으면 계속 이동 시킵시다.
 *  
 */

import java.util.*;
import java.io.*;

public class Main_17070 {
	static int n;
	static int[][] map;
	static int answer = 0;
	
	// dir => 0: 가로, 1: 세로, 2: 대각선
	private static void dfs(int r, int c, int dir) {
		// 마지막 좌표에 도착했다면 answer++
		if (r == n-1 && c == n-1) {
			answer++;
			return;
		}
		
		// 가로 파이프
		if (dir == 0 || dir == 2) {
			if (c + 1 < n && map[r][c+1] == 0) {
				dfs(r, c + 1, 0);
			}
		}
		
		// 세로 파이프
		if (dir == 1 || dir == 2) {
			if (r + 1 < n && map[r+1][c] == 0) {
				dfs(r + 1, c, 1);
			}
		}
		
		// 대각선 파이프
		if (r + 1 < n && c + 1 < n) {
			if (map[r+1][c] == 0 && map[r][c+1] == 0 && map[r+1][c+1] == 0) {
				dfs(r + 1, c + 1, 2);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,1,0); // 파이프의 오른쪽 끝부터 시작해야 하므로 (0, 1)에서 시작
		System.out.println(answer);
	}
}