import java.util.*;
import java.io.*;

public class Main_2606_bfs {
	static int v, e;
	static boolean[] visited;
	static List<ArrayList<Integer>> graph;
	
	static int answer = 0;
	
	private static void bfs() {
		visited = new boolean[v+1];
		visited[1] = true;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int nxt : graph.get(cur)) {
				if (!visited[nxt]) {
					visited[nxt] = true;
					queue.add(nxt);
					answer++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(br.readLine());
		e = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= v; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < e; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		bfs();
		
		System.out.println(answer);
	}

}
