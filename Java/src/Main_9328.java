import java.util.*;
import java.io.*;

/**
 *  .: 빈 공간
 *  *: 벽
 *  $: 훔쳐야 하는 문서
 *  대문자: 문
 *  소문자: 열쇠
 */

public class Main_9328 {
	
	static class Loc {
		int r, c;
		
		Loc (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static int w, h, cnt;
	static char[][] map;
	static boolean[] keys;
	static boolean[][] visited;
	static List<Loc> starts;
	static List<ArrayList<Loc>> gates;
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	private static void solve() {
		cnt = 0;
		visited = new boolean[h][w];
		
		gates = new ArrayList<>();
		for (int i = 0; i < 26; i++) gates.add(new ArrayList<>()); 
		
		bfs();
		
		sb.append(cnt).append('\n');
	}
	
	private static void bfs() {
		Queue<Loc> queue = new ArrayDeque<>();
		
		for (Loc start : starts) {
			if (moveable(start, queue)) {
				visited[start.r][start.c] = true;
			}
		}
		
		while (!queue.isEmpty()) {
			Loc cur = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
				if (visited[nr][nc] || map[nr][nc] == '*') continue;
				
				if (moveable(new Loc(nr, nc), queue)) {
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	private static boolean moveable(Loc start, Queue<Loc> queue) {
		char type = map[start.r][start.c];
		
		if (type == '$') {
			++cnt;
			queue.offer(start);
			return true;
		}
		
		else if (type == '.') {
			queue.offer(start);
			return true;
		}
		
		else if ('a' <= type && type <= 'z') {
			int idx = type - 'a';
			keys[idx] = true;
			queue.offer(start);
			
			for (Loc gate : gates.get(idx)) {
				queue.offer(gate);
				visited[gate.r][gate.c] = true;
			}
			
			gates.get(idx).clear();
			return true;
		}
		
		else if ('A' <= type && type <= 'Z') {
			int idx = type - 'A';
			if (keys[idx]) {
				queue.add(start);
				return true;
			} else {
				gates.get(idx).add(start);
				return false;
			}
		}
		
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			map = new char[h][w];
			starts = new ArrayList<>();
			for (int i = 0; i < h; i++) {
				String line = br.readLine();
				for (int j = 0; j < w; j++) {
					char c = line.charAt(j);
					map[i][j] = c;
					
					if (i == 0 || i == h - 1 || j == 0 || j == w - 1) {
						if (c != '*') starts.add(new Loc(i, j));
					}
				}
			}
			
			keys = new boolean[26];
			String key = br.readLine();
			if (!key.equals("0")) {
				for (int i = 0; i < key.length(); i++) {
					keys[key.charAt(i) - 'a'] = true;
				}
			}
			
			solve();
		}
		
		System.out.println(sb.toString());
	}

}
