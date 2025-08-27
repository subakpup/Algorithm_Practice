/*
 * Solution_1247 최적 경로 (D5)
 * 
 * # 문제 정리
 *  - N명의 고객을 방문
 *  - 두 위치 사이 거리는 맨해튼 거리로 계산
 *  - 회사에서 출발 -> 고객들을 모두 방문, 집에 돌아가는 경로 중 총 이동거리가 가장 짧은 경로 출력
 *  
 * # 아이디어
 *  - 재귀를 통해 모든 좌표를 탐색해보자
 *  - 맨해튼 거리를 이용해 각 좌표별 거리도 미리 계산해놓으면 편할 것 같다 !
 */
import java.util.*;
import java.io.*;

public class Solution_1247 {
	static StringBuilder sb = new StringBuilder();
	static int n, answer;
	static int[][] target, dist;
	static boolean[] visited;
	
	/**
	 * 맨해튼 거리를 구하는 메서드
	 * @param a 좌표
	 * @param b 좌표
	 * @return 맨해튼 거리
	 */
	private static int manhattan(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}
	
	/**
	 * 모든 고객의 집을 방문하는 메서드
	 * @param depth 번째 고객
	 * @param cur: 현재 탐색하는 고객 번호
	 * @param sum: 현재까지의 거리 합
	 */
	private static void dfs(int depth, int cur, int sum) {
		if (sum >= answer) return; // 현재까지의 거리합이 정답 값 보다 크다면 return (가지치기)
		
		if (depth == n) { // 모든 고객의 집을 들렸다면
			sum += dist[cur][n+1]; // 집으로 이동 거리 계산
			if (sum < answer) answer = sum; // 값 업데이트
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if (visited[i]) continue; // 방문했다면 pass
			visited[i] = true; // 아니라면 방문 처리
			dfs(depth + 1, i, sum + dist[cur][i]); // 방문한 고객 수 + 1, 현재 값 변환, 거리 계산
			visited[i] = false; // 백트래킹
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			target = new int[n+2][2];
			
			// 회사
			target[0][0] = Integer.parseInt(st.nextToken());
			target[0][1] = Integer.parseInt(st.nextToken());
			
			// 집
			target[n+1][0] = Integer.parseInt(st.nextToken());
			target[n+1][1] = Integer.parseInt(st.nextToken());
			
			// 고객
			for (int i = 1; i <= n; i++) {
				target[i][0] = Integer.parseInt(st.nextToken());
				target[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// 좌표별 거리
			dist = new int[n+2][n+2];
			for (int i = 0; i < n+2; i++) {
				for (int j = 0; j < n+2; j++) {
					dist[i][j] = manhattan(target[i], target[j]); // i에서 j까지의 거리 계산
				}
			}
			
			answer = Integer.MAX_VALUE;
			visited = new boolean[n+1]; // 방문 여부
			
			dfs(0, 0, 0); // 아무 고객도 방문 안 함 (0), 현재 좌표 (회사 = 0), 이동 거리 (0)
			
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

}
