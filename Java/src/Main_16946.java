import java.util.*;
import java.io.*;

public class Main_16946 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> group;
	
	static int num = 2;
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	private static void solve() {
		group = new ArrayList<>();
		for (int i = 0; i < 2; i++) group.add(0);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					grouping(i, j);
					++num;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) check(i, j);
				else sb.append(0);
			}
			sb.append('\n');
		}
	}
	
	private static void grouping(int sr, int sc) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { sr, sc });
		
		map[sr][sc] = num;
		visited[sr][sc] = true;
		int cnt = 1;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				if (map[nr][nc] != 0 || visited[nr][nc]) continue;
				
				++cnt;
				map[nr][nc] = num;
				visited[nr][nc] = true;
				queue.add(new int[] { nr, nc });
			}
		}
		
		group.add(cnt);
	}
	
	private static void check(int sr, int sc) {
		Set<Integer> used = new HashSet<>();

		int cnt = 1;

		for (int i = 0; i < 4; i++) {
			int nr = sr + dr[i];
			int nc = sc + dc[i];

			if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
			
			if (map[nr][nc] >= 2 && !used.contains(map[nr][nc])) {
				used.add(map[nr][nc]);
				cnt += group.get(map[nr][nc]);
			}
		}

		sb.append(cnt % 10);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		solve();
		System.out.println(sb.toString());
	}

}
