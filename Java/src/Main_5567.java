import java.util.*;
import java.io.*;

public class Main_5567 {
	static int n, m; // 동기의 수, 리스트의 길이
	static boolean[] visited; // 방문여부
	static boolean[][] graph; // 친구 관계
	static int cnt; // 초대할 친구의 수
	
	/**
	 * 탐색 시작
	 * @param 상근이
	 * @return 초대할 친구의 수
	 */
	public static int bfs(int node) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {node, 0}); // 상근이, 깊이
		visited[node] = true; // 방문처리
		
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			int person = p[0]; // 친구
			int depth = p[1]; // 깊이
			
			if (depth >= 2) break; // 친구의 친구를 초과하면 break
			
			for (int i = 1; i <= n; i++) { // 탐색할 사람의 인간 관계 탐색
				if (!visited[i] && graph[person][i]) { // 탐색한 적 없으며, 친구 관계가 존재할 경우
					queue.add(new int[] {i, depth + 1}); // 큐에 삽입, 깊이 + 1
					visited[i] = true; // 방문 처리
					cnt++; // 친구수 + 1
				}
			}
			
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		
		// 친구 관계 그래프로 저장
		graph = new boolean[n+1][n+1];
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = true;
			graph[b][a] = true;
		}
		
		System.out.println(bfs(1));
	}
}
