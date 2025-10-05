import java.util.*;
import java.io.*;

public class Main_24445 {
	static int n, m, r, cnt;
	static int[] visited;
	static List<ArrayList<Integer>> graph;
	
	private static void bfs() {
		visited[r] = ++cnt;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(r);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int node : graph.get(cur)) {
				if (visited[node] == 0) {
					queue.add(node);
					visited[node] = ++cnt;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for (int i = 1; i <= n; i++) Collections.sort(graph.get(i), Collections.reverseOrder());
		
		visited = new int[n+1];
		cnt = 0;
		
		bfs();
		
		for (int i = 1; i <= n; i++) {
			System.out.println(visited[i]);
		}
	}

}
