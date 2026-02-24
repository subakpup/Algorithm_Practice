import java.util.*;
import java.io.*;

public class Main_9466 {
	static int n, cnt;
	static int[] graph;
	static boolean[] visited, finished;
	
	private static void dfs(int cur) {
		visited[cur] = true;
		
		int nxt = graph[cur];
		
		if (!visited[nxt]) {
			dfs(nxt);
		} else if (!finished[nxt]) {
			cnt--;
			for (int i = graph[nxt]; i != nxt; i = graph[i]) {
				cnt--;
			}
		}
		
		finished[cur] = true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			graph = new int[n+1];
			visited = new boolean[n+1];
			finished = new boolean[n+1];
			cnt = n;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				graph[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= n; i++) {
				if (!finished[i]) {
					dfs(i);
				}
			}
			
			System.out.println(cnt);
		}
	}
}
