import java.util.*;
import java.io.*;

public class Main_17135 {
	
	static class Pos implements Comparable<Pos> {
		int r, c, dist;
		
		public Pos (int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Pos o) {
			if (this.dist != o.dist) {
				return Integer.compare(this.dist, o.dist);
			}
			return Integer.compare(this.c, o.c);
		}
	}
	
	static int n, m, d;
	static int[] pos;
	static int[][] map;
	
	static int answer = 0;
	
	private static void permutation(int depth, int start) {
		if (depth == 3) {
			answer = Math.max(answer, simulate());
			return;
		}
		
		for (int i = start; i < m; i++) {
			pos[depth] = i;
			permutation(depth + 1, i + 1);
		}
	}
	
	private static int simulate() {
		int[][] temp = new int[n][m];
		for (int i = 0; i < n; i++) temp[i] = map[i].clone();
		
		int killed = 0;
		
		while (true) {
			boolean flag = false;
			Search:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (temp[i][j] == 1) {
						flag = true;
						break Search;
					}
				}
			}
			
			if (!flag) break;
			
			Pos target1 = findTarget(pos[0], temp);
			Pos target2 = findTarget(pos[1], temp);
			Pos target3 = findTarget(pos[2], temp);
			
			List<Pos> targets = new ArrayList<>();
			if (target1 != null) targets.add(target1);
			if (target2 != null) targets.add(target2);
			if (target3 != null) targets.add(target3);
			
			for (Pos t : targets) {
				if (temp[t.r][t.c] == 1) {
					temp[t.r][t.c] = 0;
					++killed;
				}
			}
			
			temp = moved(temp);
		}
		
		return killed;
	}
	
	private static Pos findTarget(int p, int[][] temp) {
		List<Pos> candidates = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 1) {
					int dist = Math.abs(n - i) + Math.abs(p - j);
					candidates.add(new Pos(i, j, dist));
				}
			}
		}
		
		if (candidates.isEmpty()) return null;
		
		Collections.sort(candidates);
		
		if (candidates.get(0).dist > d) return null;
		
		return candidates.get(0);
	}
	
	private static int[][] moved(int[][] temp) {
		for (int i = n-1; i > 0; i--) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = temp[i-1][j];
			}
		}
		
		Arrays.fill(temp[0], 0);
		return temp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pos = new int[3];
		
		permutation(0, 0);
		System.out.println(answer);
	}

}
