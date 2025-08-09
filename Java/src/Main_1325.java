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

import java.util.*;
import java.io.*;

public class Main_1325 {
	static int n,m; // 컴퓨터의 수, 신뢰하는 관계의 수
	static ArrayList<Integer>[] graph; // 그래프
	static int[] hackingCnt; // 해킹할 수 있는 컴퓨터 각각의 개수
	static boolean[] visited; // 방문 여부
	static int maxCnt; // 해킹할 수 있는 최댓값
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start); // 시작 노드 삽입
		visited[start] = true; // 방문 처리
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int next : graph[cur]) { // 현재 노드와 연결된 노드 탐색
				if (!visited[next]) { // 방문하지 않았다면
					queue.add(next); // 다음 노드 삽입
					visited[next] = true; // 방문 처리
					hackingCnt[start]++;  // 해킹할 수 있는 컴퓨터 수 + 1
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 각 배열의 크기 선언
		hackingCnt = new int[n+1];
		graph = new ArrayList[n+1];
		
		// 2차원 그래프에 필요한 크기만큼만 ArrayList 선언  
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 신뢰도 설정
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[y].add(x); // A -> B가 신뢰 관계일 때, B -> A 해킹 가능
		}
		
		// 모든 컴퓨터 탐색 시작
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n+1];
			bfs(i);
		}
		
		// 최댓값 갱신
		for (int i = 1; i <= n; i++) {
			if (maxCnt < hackingCnt[i]) maxCnt = hackingCnt[i];
		}
		
		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (hackingCnt[i] == maxCnt) {
				sb.append(i).append(" ");
			}
		}
		
		System.out.println(sb);
	}

}
