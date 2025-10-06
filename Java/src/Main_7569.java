import java.util.*;
import java.io.*;

public class Main_7569 {
	static int n, m, h;
	static int[][][] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m][h];
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					graph[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		

	}

}
