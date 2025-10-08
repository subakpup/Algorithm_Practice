import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] cmd;
	static int[][] graph;
	
	private static void floyd() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (graph[i][k] == 1 && graph[k][j] == 1) {
						graph[i][j] = 1;
					}
				}
			}
		}
	}
	
	private static void getAnswer() {
		for (int i = 0; i < m - 1; i++) {
			if (graph[cmd[i]][cmd[i+1]] == 0) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	m = Integer.parseInt(br.readLine());
    	
    	graph = new int[n+1][n+1];
    	for (int i = 1; i <= n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for (int j = 1; j <= n; j++) {
    			graph[i][j] = Integer.parseInt(st.nextToken());
    			if (i == j) graph[i][j] = 1;
    		}
    	}
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	cmd = new int[m];
    	for (int i = 0; i < m; i++) {
    		cmd[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	floyd();
    	getAnswer();
    }
}