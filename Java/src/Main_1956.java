import java.util.*;
import java.io.*;

public class Main_1956 {
	
	static int v, e;
	static int[][] graph;
	static final int INF = 1_000_000_000;
	
	private static void floydWarshall() {
		for (int k = 1; k <= v; k++) {
			for (int i = 1; i <= v; i++) {
				for (int j = 1; j <= v; j++) {
					if (i == j) continue;
					if (graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
	}
	
	private static void printAnswer() {
		int answer = INF;
		for (int i = 1; i <= v; i++) {
			for (int j = 1; j <= v; j++) {
				if (graph[i][j] == INF || graph[j][i] == INF) continue;
				answer = Math.min(answer, graph[i][j] + graph[j][i]);
			}
		}
		
		System.out.println(answer == INF ? -1 : answer);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		graph = new int[v+1][v+1];
		for (int i = 1; i <= v; i++) Arrays.fill(graph[i], INF);
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a][b] = c;
		}
		
		floydWarshall();
		printAnswer();
	}

}
