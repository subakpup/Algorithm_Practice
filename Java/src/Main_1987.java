import java.util.*;
import java.io.*;

public class Main_1987 {
	static int r, c;
	static int[][] graph;
	
	static int answer = 0;
	static boolean[] visited = new boolean[26];
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	private static void dfs(int depth, int sr, int sc) {
		if (answer < depth) {
			answer = depth;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = sr + dr[i];
			int nc = sc + dc[i];
			
			if (nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
			if (visited[graph[nr][nc]]) continue;
			
			visited[graph[nr][nc]] = true;
			dfs(depth + 1, nr, nc);
			visited[graph[nr][nc]] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		graph = new int[r][c];
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				graph[i][j] = s.charAt(j) - 'A';
			}
		}
		
		visited[graph[0][0]] = true;
		dfs(1, 0, 0);
		System.out.println(answer);
	}

}
