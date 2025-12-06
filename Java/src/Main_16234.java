import java.util.*;
import java.io.*;

public class Main_16234 {
	static int n, l, r;
	static int[][] map;
	static boolean[][] visited;
	
	static int answer = 0;
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	private static int solve() {
		int cnt = 0;
		
		while (true) {
			visited = new boolean[n][n];
			boolean isValid = false;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						if (bfs(i, j) > 1) isValid = true;
					}
				}
			}
			
			if (!isValid) break;
			++cnt;
		}
		
		return cnt;
	}
	
	private static int bfs(int sr, int sc) {
		Queue<int[]> queue = new ArrayDeque<>();
		List<int[]> group = new ArrayList<>();
		
		queue.add(new int[] { sr, sc });
		group.add(new int[] { sr, sc });
		visited[sr][sc] = true;
		
		int sum = map[sr][sc];
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) continue;
				
				int diff = Math.abs(map[cur[0]][cur[1]] - map[nr][nc]);
				
				if (l <= diff && diff <= r) {
					visited[nr][nc] = true;
					sum += map[nr][nc];
					queue.add(new int[] { nr, nc });
					group.add(new int[] { nr, nc });
				}
			}
		}
		
		if (group.size() > 1) {
			int popul = sum / group.size();
			for (int[] cur : group) {
				map[cur[0]][cur[1]] = popul;
			}
		}
		
		return group.size();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(solve());
	}

}
