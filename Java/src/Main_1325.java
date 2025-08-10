/*
 * Main_1325 효율적인 해킹 (실버1)
 * - 메모리: 303624KB
 * - 시간: 10944ms
 * 
 *  # 문제 정리
 *   - N개의 컴퓨터
 *   - 한 번의 해킹으로 여러 컴퓨터를 해킹
 *   - 컴퓨터는 신뢰하는 관계, 신뢰하지 않는 관계
 *   - A가 B를 신뢰하는 경우 -> B를 해킹하면 A도 해킹할 수 있다.(단방향 간선)
 *   - 회사의 컴퓨터의 신뢰하는 관계가 주어졌을 때, 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력
 *   
 *  # 아이디어
 *   - 전형적인 그래프 탐색 문제
 *   - DFS, BFS로 풀 수 있지만 **BFS**를 선택!
 *   - N과 M의 범위가 각각 10,000으로 굉장히 큽니다.
 *   - 최적화를 열심히 해야 합니다..
 *   - 평소에 2차원 배열을 선언하였으나, 최적화를 위해 ArrayList를 사용(공간 최적화)
 */

import java.io.*;
import java.util.*;

public class Main_1325 {
	static int n, m;
	static List<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int cnt;
	static int[] isHacked;
	static StringBuilder sb = new StringBuilder();
	
	public static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int node = queue.poll();
			
			for (int cur : graph.get(node)) {
				if (!visited[cur]) {
					queue.add(cur);
					visited[cur] = true;
					isHacked[start]++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(b).add(a);
		}
		
		isHacked = new int[n+1];
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n+1];
			bfs(i);
			if (answer < isHacked[i]) answer = isHacked[i];
		}
		
		for (int i = 1; i <= n; i++) {
			if (isHacked[i] == answer) {
				sb.append(i + " ");
			}
		}
		
		System.out.println(sb);
		
	}
}

