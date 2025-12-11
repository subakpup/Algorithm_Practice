import java.util.*;
import java.io.*;

public class Main_4963 {
	
	static class Pos {
		int r, c;
		
		Pos (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static int w, h, answer;
	static int[][] map;
	static boolean[][] visited;
	
	static final int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static final int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
	
	private static void solve() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					++answer;
					bfs(i, j);
				}
			}
		}
	}
	
	private static void bfs(int r, int c) {
		Queue<Pos> queue = new ArrayDeque<>();
		queue.add(new Pos(r, c));
		visited[r][c] = true;
		
		while (!queue.isEmpty()) {
			Pos cur = queue.poll();
			
			for (int i = 0; i < 8; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if (nr < 0 || nr >= h || nc < 0 || nc >= w || map[nr][nc] == 0 || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				queue.add(new Pos(nr, nc));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w == 0 && h == 0) break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			answer = 0;
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			solve();
			sb.append(answer).append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
