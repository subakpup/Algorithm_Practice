import java.util.*;
import java.io.*;

public class Solution_1861 {
	static StringBuilder sb = new StringBuilder();
	static int n, dist, room;
	static int[][] map;
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	private static void solve() {
		dist = 0; room = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int tmp = bfs(i, j);
				if (dist < tmp) {
					dist = tmp;
					room = map[i][j];
				} else if (dist == tmp) {
					if (room > map[i][j]) room = map[i][j];
				}
			}
		}
	}
	
	private static int bfs(int sr, int sc) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { sr, sc });
		
		int d = 1;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				
				if (map[r][c] + 1 == map[nr][nc]) {
					queue.add(new int[] { nr, nc });
					++d;
				}
			}
		}
		
		return d;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			solve();
			
			sb.append('#').append(tc).append(' ').append(room).append(' ').append(dist).append('\n');
		}
		
		System.out.print(sb.toString());
	}
}
