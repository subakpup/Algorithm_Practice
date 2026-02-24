/*
 * Solution_3124 최소 스패닝 트리 (D4)
 * 
 * # 문제 정리
 *  - 그래프가 주어졌을 때, 그 그래프의 MST를 구하라
 *  - 정점의 개수 V, 간선의 개수 E
 *  - A번 정점 -> B번 정점, 가중치 C
 *  
 * # 아이디어
 *  - 프림 알고리즘
 *  - 객체 선언에 익숙해집시다..
 */
import java.util.*;
import java.io.*;

public class Solution_3124_Prim {
	static class Edge implements Comparable<Edge> {
		int to, w;

		public Edge(int to, int w) {
			super();
			this.to = to;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int v, e;
	static long answer;
	static List<List<Edge>> adj;
	
	private static void prim(int start) {
		boolean[] visited = new boolean[v+1]; // 방문 여부
		PriorityQueue<Edge> pq = new PriorityQueue<>(); // 최소 힙
		pq.offer(new Edge(start, 0)); // 정점, 가중치
		answer = 0L;
		int cnt = 0;
		
		while (!pq.isEmpty() && cnt < v) {
			Edge cur = pq.poll();
			int u = cur.to; // 정점 추출
			if (visited[u]) continue; // 연결된 정점이라면 pass
			visited[u] = true; // 아니라면 방문 처리
			answer += cur.w; // 가중치 부여
			cnt++; // 연결횟수++
			
			// 이웃 정점 탐색
			for (Edge e : adj.get(u)) {
				if (!visited[e.to]) { // 방문하지 않았다면
					pq.offer(e); // 힙에 추가
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList<>();
			for (int i = 0; i <= v; i++) {
				adj.add(new ArrayList<>());
			}
			
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				adj.get(a).add(new Edge(b, w));
				adj.get(b).add(new Edge(a, w));
			}
			
			prim(1);
			
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

}
