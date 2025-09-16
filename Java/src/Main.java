import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static final int INF = (int) 1e9;
	static int n, m;
	static int[][] dist;
	
	private static void floyd() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
	}
	
	private static void setAnswer() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(dist[i][j] == INF ? 0 : dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	m = Integer.parseInt(br.readLine());
    	
    	dist = new int[n+1][n+1];
    	for (int i = 1; i <= n; i++) {
    		Arrays.fill(dist[i], INF);
    		dist[i][i] = 0;
    	}
    	
    	for (int i = 0; i < m; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		dist[a][b] = Math.min(dist[a][b], c);
    	}
    	
    	floyd();
    	setAnswer();
    	
    	System.out.println(sb.toString());
    }
}