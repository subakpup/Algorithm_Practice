/*
 * Solution_1251 하나로 (D4)
 * 
 * # 문제 정리
 *  - N개의 섬들을 연결
 *  - 환경 부담 세율(E)과 각 해저터널 길이(L)의 제곱의 곱(E*L^2)만큼 지불
 *  - 총 환경 부담금을 최소로 지불하며, N개의 섬을 연결할 수 있는 시스템을 설계
 *  
 * # 아이디어
 *  - 최소 신장 트리
 *  - Edge 클래스를 정의하여 간선들 관리
 *  - 프림 알고리즘
 */
import java.util.*;
import java.io.*;

public class Solution_1251_Prim {
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n;
	static double e;
	static int[] x, y;
	
	private static long prim() {
		boolean[] visited = new boolean[n]; // MST 포함 여부
		long[] dist = new long[n]; // MST 최소 비용
		Arrays.fill(dist, Long.MAX_VALUE); // 초기에는 무한대(연결 전)
		dist[0] = 0; // 시작 정점 비용 0으로 시작
		
		long total = 0L; // MST 거리 제곱 합
		
		for (int idx = 0; idx < n; idx++) {
			int u = -1;
			long best = Long.MAX_VALUE;
			
			// 방문하지 않은 정점 중, 가장 싸게 붙일 수 있는 정점 u 선택
			for (int i = 0; i < n; i++) {
				if (!visited[i] && dist[i] < best) {
					best = dist[i];
					u = i;
				}
			}
			
			// 정점 u를 MST에 포함
			visited[u] = true;
			total += best; // 시작 정점의 best는 0
			
			for (int v = 0; v < n; v++) {
				if (!visited[v]) {
					long dx = (long) x[u] - x[v];
					long dy = (long) y[u] - y[v];
					long w = dx * dx + dy * dy;
					if (w < dist[v]) dist[v] = w;
				}
			}
		}
		
		return total;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			x = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			
			y = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			e = Double.parseDouble(br.readLine());
			
			long sum = prim();
			long answer = Math.round(sum * e);
			
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

}
