import java.util.*;
import java.io.*;

public class Main_13023 {
	static int n, m, answer;
	static boolean[] visited;
	static List<ArrayList<Integer>> graph;
	
	private static void dfs(int depth, int cur) {
		if (depth == 5) {
			answer = 1;
			return;
		}
		
		visited[cur] = true;
		for (int nxt : graph.get(cur)) {
			if (!visited[nxt]) dfs(depth + 1, nxt);
			
			if (answer == 1) return;
		}
		visited[cur] = false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		visited = new boolean[n];
		answer = 0;
		for (int i = 0; i < n; i++) {
			dfs(1, i);
			if (answer == 1) break;
		}
		
		System.out.println(answer);
	}

}
