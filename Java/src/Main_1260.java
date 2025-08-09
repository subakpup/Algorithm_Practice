import java.util.*;
import java.io.*;

public class Main_1260 {
	static int n,m,v;
	static boolean[][] graph;
	static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int start, boolean[] visited) {
		visited[start] = true;
		sb.append(start).append(" ");
		for (int i = 1; i <= n; i++) {
			if (!visited[i] && graph[start][i]) {
				dfs(i, visited);
			}
		}
	}
	
	public static void bfs(int start, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		sb.append(start).append(" ");
		
		while (!queue.isEmpty()) {
			int node = queue.poll();
			
			for (int i = 1; i <= n; i++) {
				if (!visited[i] && graph[node][i]) {
					queue.add(i);
					visited[i] = true;
					sb.append(i).append(" ");
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		graph = new boolean[n+1][n+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y] = true;
			graph[y][x] = true;
		}
		
		boolean[] dfs_visited = new boolean[n+1];
		dfs(v, dfs_visited);
		sb.append("\n");
		
		boolean[] bfs_visited = new boolean[n+1];
		bfs(v, bfs_visited);
		
		System.out.println(sb);
	}

}
