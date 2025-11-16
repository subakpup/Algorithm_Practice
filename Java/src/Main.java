import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] graph;
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;
	
	private static void dfs(int idx, int cnt) {
		if (cnt == n/2) {
			calculate();
			return;
		}
		
		for (int i = idx; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i + 1, cnt + 1);
				visited[i] = false;
			}
		}
	}
	
	private static void calculate() {
		int teamA = 0, teamB = 0;
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (visited[i] && visited[j]) {
					teamA += graph[i][j] + graph[j][i];
				}
				
				else if (!visited[i] && !visited[j]) {
					teamB += graph[i][j] + graph[j][i];
				}
			}
		}
		
		int tmp = Math.abs(teamA - teamB);
		answer = Math.min(tmp, answer);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n];

		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		System.out.println(answer);
	}

}
