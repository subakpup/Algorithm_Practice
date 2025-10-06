import java.util.*;
import java.io.*;

public class Main_7569 {
	static int n, m, o, answer;
	static int[][][] graph, visited;
	
	static Queue<int[]> queue = new ArrayDeque<>();
	
	static final int[] dr = { -1, 1, 0, 0, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1, 0, 0 };
	static final int[] dh = { 0, 0, 0, 0, -1, 1 };
	
	private static void init() {
		graph = new int[n][m][o];
		visited = new int[n][m][o];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				Arrays.fill(visited[i][j], -1);
			}
		}
	}
	
	private static void bfs() {
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1], h = cur[2];
			
			for (int i = 0; i < 6; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				int nh = h + dh[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m || nh < 0 || nh >= o) continue;
				if (graph[nr][nc][nh] == -1 || visited[nr][nc][nh] != -1) continue;
				
				queue.add(new int[] { nr, nc, nh });
				visited[nr][nc][nh] = visited[r][c][h] + 1;
			}
		}
		
	}
	
	private static void computeAnswer() {
		answer = 0;
		for (int k = 0; k < o; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (graph[i][j][k] != -1 && visited[i][j][k] == -1) {
						answer = -1;
						return;
					}
					if (visited[i][j][k] > answer) answer = visited[i][j][k];
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		o = Integer.parseInt(st.nextToken());
		
		init();
		
		for (int k = 0; k < o; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					graph[i][j][k] = Integer.parseInt(st.nextToken());
					if (graph[i][j][k] == 1) {
						queue.add(new int[] { i, j, k });
						visited[i][j][k] = 0;
					}
				}
			}
		}
		
		bfs();
		computeAnswer();
		
		System.out.println(answer);
	}

}
