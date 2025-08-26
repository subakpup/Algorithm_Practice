/*
 * Solution_3124 최소 스패닝 트리 (D4)
 * 
 * # 문제 정리
 *  - 그래프가 주어졌을 때, 그 그래프의 MST를 구해라
 *  - MST란, 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서
 *    그 가중치의 합이 최소인 트리를 말한다.
 *  - 정점의 개수 V, 간선의 개수 E
 *  - A번 정점 -> B번 정점, 가중치 C
 *  
 * # 아이디어
 *  - kruskal 알고리즘을 사용하자 !
 *  - 그러려면 Union-Find 알고리즘을 사용해야 한다.
 *  - 가중치 기준 오름차순으로 정렬을 해야 한다 !
 */
import java.util.*;
import java.io.*;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int v, e;
	static int[][] edges;
	static int[] p, s;

	/**
	 * 부모, 집합의 크기 배열 초기화
	 */
	private static void make(int n) {
		p = new int[n + 1];
		s = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			p[i] = i; // 부모를 자기 자신으로 초기화
			s[i] = 1; // 현재 부모는 자기 자신이라 크기는 1로 초기화
		}
	}

	/**
	 * x의 부모를 찾는 메서드
	 */
	private static int find(int x) {
		while (p[x] != x) {
			p[x] = p[p[x]];
			x = p[x];
		}
		return x;
	}

	/**
	 * b를 a의 집합에 속하게 만드는 메서드
	 */
	private static boolean union(int a, int b) {
		int ra = find(a); // a의 루트
		int rb = find(b); // b의 루트

		if (ra == rb) { // a의 루트와 b의 루트가 같다면(같은 집합이라면) false return
			return false;
		}

		/*
		 * rb를 ra 밑에 넣으려고 한다. 그러려면 ra가 더 큰 집합임을 가정해야 한다. 그러나 rb의 크기가 더 크다면 이를 해결하기 위해
		 * swap 해준다.
		 */
		if (s[ra] < s[rb]) {
			int tmp = ra;
			ra = rb;
			rb = tmp;
		}

		p[rb] = ra; // rb의 부모를 ra로 할당
		s[ra] += s[rb]; // rb가 ra의 밑으로 들어갔으니, ra의 크기에 rb의 크기를 더해준다.
		return true; // union 연산을 했으니 true return
	}

	/**
	 * 최소 신장 트리의 비용을 구하는 메서드 크루스칼 이용
	 */
	private static long kruskal() {
		Arrays.sort(edges, Comparator.comparing(a -> a[0])); // 가중치 기준으로 오름차순 정렬

		make(v); // 부모, 크기 배열 초기화
		long mstCost = 0; // 트리 비용
		int usedEdges = 0; // 사용한 간선 수

		for (int[] edge : edges) {
			if (union(edge[1], edge[2])) { // a와 b가 union 연산을 했다면,
				mstCost += edge[0]; // 비용에 가중치만큼 추가
				usedEdges++; // 사용한 간선 수 + 1

				if (usedEdges == v - 1) { // 만약 간선 수가 v-1개라면 트리가 완성된 것이므로 break
					break; 
				}
			}
		}

		return mstCost; // 트리를 만드는 데 사용한 비용 리턴
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken()); // 정점의 개수
			e = Integer.parseInt(st.nextToken()); // 간선의 개수
			edges = new int[e][3];
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				edges[i][1] = Integer.parseInt(st.nextToken()); // 정점 A
				edges[i][2] = Integer.parseInt(st.nextToken()); // 정점 B
				edges[i][0] = Integer.parseInt(st.nextToken()); // 가중치
			}

			sb.append("#" + tc + " " + kruskal() + "\n");
		}
		System.out.println(sb.toString());
	}

}
