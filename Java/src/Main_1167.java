import java.util.*;
import java.io.*;

public class Main_1167 {
	
	static class Node {
		int idx, dist;
		
		public Node (int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
	}
	
	static int v, start, answer;
	static boolean[] visited;
	static List<ArrayList<Node>> graph;
	
	private static void solve() {
		visited = new boolean[v+1];
		dfs(1, 0);
		
		visited = new boolean[v+1];
		answer = 0;
		dfs(start, 0);
	}
	
	private static void dfs(int cur, int dist) {
		if (dist > answer) {
			answer = dist;
			start = cur;
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
		v = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= v; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			while (true) {
				int idx = Integer.parseInt(st.nextToken());
				if (idx == -1) break;
				
				int dist = Integer.parseInt(st.nextToken());
				graph.get(n).add(new Node(idx, dist));
			}
			
		}
		
		solve();
		System.out.println(answer);
	}

}
