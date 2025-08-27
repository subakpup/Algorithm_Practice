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
 *  - 크루스칼 알고리즘 + 유니온 파인드
 */
import java.util.*;
import java.io.*;

public class Solution_1251 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static double e;
	static int[] p, s;
	static int[][] edges;
	
	// 간선을 나타낼 클래스
	static class Edge implements Comparable<Edge> {
		int u, v; // 연결하는 두 섬 번호
		long w; // 섬과 섬 사이 거리 제곱
		
		Edge(int u, int v, long w){
			super();
			this.u = u;
			this.v = v;
			this.w = w;
		}

		// 가중치 오름차순 정렬
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.w, o.w);
		}
		
	}
	
	// 부모, 집합 크기 배열 초기화
	private static void make() {
		p = new int[n+1];
		s = new int[n+1];
		for (int i = 0; i < n; i++) {
			p[i] = i; // 부모를 자기 자신으로 초기화
			s[i] = 1; // 집합 크기 = 1
		}
	}
	
	// Find 경로 압축
	private static int find(int x) {
		if (p[x] == x) return x;
		return p[x] = find(p[x]);
	}
	
	// Union 집합 합치기, 작은 쪽을 큰 쪽에 합침
	private static boolean union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		
		if (ra == rb) return false; // 이미 같은 집합이면 합칠 수 없으므로 false return
		
		if (s[ra] < s[rb]) {
			int tmp = ra;
			ra = rb;
			rb = tmp;
		}
		
		p[rb] = ra;
		s[ra] += s[rb];
		return true;
	}
	
	// 크루스칼 알고리즘으로 MST 구하기
	private static long kruskal(Edge[] edges) {
		Arrays.sort(edges); // 간선을 가중치 기준으로 오름차순 정렬
		make(); // Union-Find 초기화
		long mst_cost = 0L; // 비용 합
		int used_edges = 0; // 사용한 간선 수
		
		for (Edge e : edges) {
			if (union(e.u, e.v)) { // 같은 집합이 아니라면(사이클이 생기지 않는다면) 간선 채택
				mst_cost += e.w;
				if (++used_edges == n - 1) break; // 간선을 모두 사용했다면 MST 완성
			}
		}
		
		return mst_cost; // MST 제곱거리 합 반환
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine()); // 섬 개수
			
			int[] x = new int[n]; // 섬의 x 좌표
			int[] y = new int[n]; // 섬의 y 좌표
			
			// x 좌표 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			
			// y 좌표 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			// 환경 부담 세율
			e = Double.parseDouble(br.readLine());
			
			// 모든 섬 쌍에 대한 간선 생성
			int m = n * (n - 1) / 2; // 간선 개수 = nC2
			Edge[] edges = new Edge[m];
			int idx = 0;
			for (int i = 0; i < n; i++) {
				for(int j = i + 1; j < n; j++) {
					long dx = (long) x[i] - x[j];
					long dy = (long) y[i] - y[j];
					long w = dx * dx + dy * dy; // 맨해튼 거리
					edges[idx++] = new Edge(i, j, w);
				}
			}
			
			long answer = Math.round(kruskal(edges) * e); // 제곱거리 합 * 환경 부담금, 반올림
			
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

}
