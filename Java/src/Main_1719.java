/*
 * Main_1719 택배 (골드 3)
 *  - 메모리: 21924
 *  - 시간: 284
 * 
 * # 문제 정리
 *  - 택배 화물이 각 집하장 사이를 오갈 때 어떤 경로를 거치는지 경로표를 작성
 *  - 정점: 집하장, 간선: 화물이 이동 가능한 경로, 가중치: 이동에 걸리는 시간
 *  
 * # 아이디어
 *  - Floyd-Warshall
 *  - 최단 거리를 찾으며, 처음 만난 노드를 저장하자
 *  - 배열 2개 만들기 귀찮아서 3차원 배열로 풀었읍니다.
 */

import java.util.*;
import java.io.*;

public class Main_1719 {
	
	static StringBuilder sb = new StringBuilder();
	static final int INF = (int) 1e9; // 최댓값
	
	static int n, m;
	static int[][][] dist;
	
	private static void floyd() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j) continue;
					
					if (dist[i][j][0] > dist[i][k][0] + dist[k][j][0]) { // 가중치가 최소인 경우
						dist[i][j][0] = dist[i][k][0] + dist[k][j][0]; // 가중치 업데이트
						dist[i][j][1] = dist[i][k][1]; // 가리키고 있는 노드 업데이트
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 배송지의 정보를 담을 배열 초기화(좌표 r, 좌표 c, [가중치, 가리키고 있는 노드])
		dist = new int[n+1][n+1][2];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				Arrays.fill(dist[i][j], INF);
			}
		}
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); // 출발지
			int to = Integer.parseInt(st.nextToken()); // 도착지
			int weight = Integer.parseInt(st.nextToken()); // 가중치
			
			int tmp = Math.min(dist[from][to][0], weight); // 저장된 가중치와 입력된 가중치 비교
			
			// 양방향 그래프
			dist[from][to][0] = tmp;
			dist[to][from][0] = tmp;
			dist[from][to][1] = to;
			dist[to][from][1] = from;
		}
		
		floyd();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int v = dist[i][j][1];
				sb.append((v == INF) ? "-" : dist[i][j][1]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
