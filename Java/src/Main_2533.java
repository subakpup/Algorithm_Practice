import java.util.*;
import java.io.*;

public class Main_2533 {
	static int n, m, answer;
	static List<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int[][] dp;
	
	private static void dfs(int cur) {
		visited[cur] = true;
		dp[cur][0] = 1;
		
		for (int nxt : graph.get(cur)) {
			if (visited[nxt]) continue;
			dfs(nxt);
			dp[cur][1] += dp[nxt][0];
			dp[cur][0] += Math.min(dp[nxt][0], dp[nxt][1]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		dp = new int[n+1][2];
		visited = new boolean[n+1];
		
		dfs(1);
		
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}

}
