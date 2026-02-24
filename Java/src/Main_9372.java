import java.util.*;
import java.io.*;

public class Main_9372 {
	
	static int n, m;
	static boolean[] visited;
	static List<ArrayList<Integer>> graph;
	
	private static int dfs(int cur, int cnt) {
		visited[cur] = true;
		for (int nxt : graph.get(cur)) {
			if (!visited[nxt]) {
				cnt = dfs(nxt, cnt + 1);
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			
			visited = new boolean[n+1];
			int answer = dfs(1, 0);
			System.out.println(answer);
		}
	}

}
