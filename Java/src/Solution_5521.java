import java.util.*;
import java.io.*;

public class Solution_5521 {
	static StringBuilder sb = new StringBuilder();
	static int n, m, cnt;
	static List<ArrayList<Integer>> graph;

	private static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { 1, 0 });
		
		boolean[] visited = new boolean[n+1];
		visited[1] = true;
		
		while (!queue.isEmpty()) {
			int[] pop = queue.poll();
			int cur = pop[0], rel = pop[1];
			
			for (int nxt : graph.get(cur)) {
				if (visited[nxt] || rel + 1 > 2) continue;
				
				visited[nxt] = true;
				queue.add(new int[] { nxt, rel + 1 });
			}
		}
		
		for (boolean v : visited) if (v) ++cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
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
			
			cnt = 0;
			bfs();
			
			sb.append('#').append(tc).append(' ').append(cnt-1).append('\n');
		}
		System.out.println(sb.toString());
	}
}
