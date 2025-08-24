/*
 * Solution_1267 작업순서
 * 
 * # 문제 정리
 *  - V개의 작업
 *  - 어떤 작업은 특정 작업이 끝나야 시작할 수 있으며 이를 **선행 관계**라고 함
 *  - 선행 관계를 나타낸 그래프
 *  - 각 작업은 하나의 정점으로 표시, 선행 관계는 방향성을 가진 간선을 ㅗ표현된다.
 *  - 사이클 존재 X
 * 
 * # 아이디어
 *  - 그래프를 그릴 때 선행 관계가 있는 노드들의 좌표에 선행 관계가 얼마나 있는지 저장할 배열이 있으면 좋겠다!
 *  - BFS를 이용해 선행 관계가 없는 노드들만 추출해 이용하자
 */
import java.io.*;
import java.util.*;

public class Solution_1267 {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int v, e;
	static List<ArrayList<Integer>> graph;
	static int[] ind;
	
	private static String bfs() {
		StringBuilder answer = new StringBuilder(); // 작업 순서 저장
		
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= v; i++) {
			if (ind[i] == 0) queue.add(i); // 선행 관계가 없는 노드들만 우선적으로 추출
		}
		
		while (!queue.isEmpty()) {
			int node = queue.poll();
			answer.append(node + " "); // 선행 관계가 없는 것들이므로 정답 문자열에 추가
			for (int nxt : graph.get(node)) { // 현재 노드와 연결된 노드 탐색
				if (--ind[nxt] == 0) { // 현재 노드가 빠져나갔으므로 1 감소 시킨후, 선행 관계가 더 이상 없다고 판단되면
					queue.add(nxt); // 큐에 추가
				}
			}
		}
		
		return answer.toString().trim();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken()); // 노드 수
			e = Integer.parseInt(st.nextToken()); // 간선 수
			
			// 그래프 초기화
			graph = new ArrayList<>();
			for (int i = 0; i <= v; i++) {
				graph.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			ind = new int[v+1]; // 선행 관계 배열
			for (int i = 0; i < e; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b); // a -> b
				ind[b]++; // b의 선행 관계 a가 있으므로 ind[b] 증가
			}
			
			sb.append("#" + tc + " " + bfs() + "\n");
		}
		System.out.println(sb);
	}
}
