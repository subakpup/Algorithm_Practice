import java.io.*;
import java.util.*;

public class Main_11724 {
	static int n, m; // 정점의 개수, 간선의 개수
	static boolean[][] graph; // 그래프
	static boolean[] visited; // 방문 여부
	
	public static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start); // 시작 노드 삽입
		visited[start] = true; // 방문 처리
		
		while (!queue.isEmpty()) {
			int node = queue.poll(); // 큐에서 pop
			
			for (int i = 1; i <= n; i++) {
				if (!visited[i] && graph[node][i]) { // 방문하지 않았고 연결된 노드라면
					queue.add(i); // 큐에 추가
					visited[i] = true; // 방문 처리
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
        // 연결 요소 입력
		graph = new boolean[n+1][n+1];
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = true;
			graph[b][a] = true;
		}
		
        // 탐색 진행
		int answer = 0;
		visited = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) { // 방문하지 않은 노드일 경우에 탐색 시작
				bfs(i);
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}
