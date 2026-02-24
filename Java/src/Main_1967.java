import java.util.*;
import java.io.*;

public class Main_1967 {
	
	static class Node {
		int idx, dist;
		
		public Node (int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
	}
	
	static int n, maxNode, maxDist;
	static boolean[] visited;
	static List<ArrayList<Node>> graph;
	
	private static void solve() {
		visited = new boolean[n+1];
		dfs(1, 0);
		
		visited = new boolean[n+1];
		maxDist = 0;
		dfs(maxNode, 0);
	}
	
	private static void dfs(int cur, int dist) {
		if (dist > maxDist) {
			maxDist = dist;
			maxNode = cur;
		}
		
		visited[cur] = true;
		
		for (Node nxt : graph.get(cur)) {
			if (!visited[nxt.idx]) {
				dfs(nxt.idx, dist + nxt.dist);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		
		if (n==1) {
			System.out.println(0);
			return;
		}
		
		solve();
		System.out.println(maxDist);
	}

}
