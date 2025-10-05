import java.util.*;
import java.io.*;

public class Main_24480 {
	static int n, m, r;
	static int[] visited;
	static List<ArrayList<Integer>> graph;
	
	static int cnt = 0;
	
	private static void dfs(int start) {
		visited[start] = ++cnt;
		
		for (int cur : graph.get(start)) {
			if (visited[cur] == 0) {
				dfs(cur);
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
		
		dfs(r);
		
		for (int i = 1; i <= n; i++) {
			System.out.println(visited[i]);
		}
	}

}
