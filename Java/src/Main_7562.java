import java.util.*;
import java.io.*;

public class Main_7562 {
	static StringBuilder sb = new StringBuilder();
	static int n, sr, sc, er, ec;
	static int[][] visited;
	
	static final int[] dr = { -2, -1, 1, 2, -2, -1, 1, 2 };
	static final int[] dc = { -1, -2, -2, -1, 1, 2, 2, 1 };
	
	private static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { sr, sc });
		visited[sr][sc] = 1;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1];
			
			if (r == er && c == ec) return;
			
			for (int i = 0; i < 8; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				if (visited[nr][nc] != 0) continue;
				
				queue.add(new int[] { nr, nc });
				visited[nr][nc] = visited[r][c] + 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			
			visited = new int[n][n];
			
			bfs();
			
			sb.append(visited[er][ec] - 1).append('\n');
			
		}
		
		System.out.println(sb.toString());
		
	}

}
