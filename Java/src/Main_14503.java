import java.util.*;
import java.io.*;

public class Main_14503 {
	
	static class Pos {
		int r, c, d;
		
		public Pos (int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static int n, m, cnt;
	static int sr, sc, sd;
	static int[][] map;
	static boolean[][] visited;
	
	static Pos p;
	
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };
	
	private static void action() {
		while (true) {
			// 현재 칸이 청소되지 않은 경우, 현재 칸을 청소한다.
			if (!visited[p.r][p.c]) {
				visited[p.r][p.c] = true;
				++cnt;
			}

			// 현재 칸의 주변 4칸 탐색
			boolean isDirty = false;
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (!isIn(nr, nc)) continue;
				
				if (!visited[nr][nc] && map[nr][nc] == 0) {
					isDirty = true;
					break;
				}
			}
			
			// 주변 4칸 중 더러운 칸이 없는 경우
			if (!isDirty) {
				// 바라보는 방향을 유지한 채로 한 칸 후진
				int nr = p.r - dr[p.d];
				int nc = p.c - dc[p.d];
				
				// 뒤쪽 칸이 벽 or 범위 밖이라 후진할 수 없다면 작동을 멈춘다.
				if (!isIn(nr, nc) || map[nr][nc] == 1) break;
				
				p.r = nr;
				p.c = nc;
			} 
			// 주변 4칸 중 더러운 칸이 있는 경우 
			else {
				// 반시계 방향으로 90도 회전
				p.d = (p.d + 3) % 4;
				
				// 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
				int nr = p.r + dr[p.d];
				int nc = p.c + dc[p.d];
				
				if (isIn(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc]) {
					p.r = nr;
					p.c = nc;
				}
			}
		}
	}
	
	private static boolean isIn(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m ;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		sd = Integer.parseInt(st.nextToken());
		
		p = new Pos(sr, sc, sd);
		
		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = 0;
		action();
		
		System.out.println(cnt);
	}

}
