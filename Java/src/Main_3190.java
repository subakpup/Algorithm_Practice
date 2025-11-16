import java.util.*;
import java.io.*;

public class Main_3190 {
	static int n, k, l;
	static int[][] map; // 0: 빈칸, 1: 뱀, 2: 사과
	static int[][] dir; // 좌표별 방향
	static int hr = 0, hc = 0, tr = 0, tc = 0, d = 0, cnt = 0;
	static Map<Integer, String> curve = new HashMap<>();
	
	// 동 -> 남 -> 서 -> 북
	static final int[] dr = { 0, 1, 0, -1 };
	static final int[] dc = { 1, 0, -1, 0 };
	
	private static void simulate() {
		while (true) {
			++cnt;
			
			int nr = hr + dr[d];
			int nc = hc + dc[d];
			
			if (nr < 0 || nr >= n || nc < 0 || nc >= n || map[nr][nc] == 1) return;
			
			dir[hr][hc] = d;
			
			hr = nr;
			hc = nc;
			
			if (map[hr][hc] == 0) {
				map[tr][tc] = 0;
				
				int tail = dir[tr][tc];
				
				tr += dr[tail];
				tc += dc[tail];
			}
			
			map[hr][hc] = 1;
			
			if (curve.containsKey(cnt)) {
				String crv = curve.get(cnt);
				
				if (crv.equals("L")) {
					d = (d + 3) % 4;
				} else {
					d = (d + 1) % 4;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		map[0][0] = 1;
		
		dir = new int[n][n];
		for (int i = 0; i < n; i++) Arrays.fill(dir[i], -1);
		
		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = 2;
		}
		
		l = Integer.parseInt(br.readLine());
		for (int i = 0; i < l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int move = Integer.parseInt(st.nextToken());
			String crv = st.nextToken();
			curve.put(move, crv);
		}
		
		simulate();
		System.out.println(cnt);
	}

}
