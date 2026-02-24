import java.util.*;
import java.io.*;

public class Main_1007 {
	
	static class Pos {
		int r, c;
		
		Pos (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static int n, l;
	static Pos[] pos;
	static boolean[] visited;
	static double sumR, sumC;
	static double answer;
	
	private static void dfs(int idx, int start, double sr, double sc) {
		if (idx == l) {
			double tr = sr * 2 - sumR;
			double tc = sc * 2 - sumC;
			double total = tr * tr + tc * tc;
			if (answer > total) answer = total;
			return;
		}
		
		for (int i = start; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(idx + 1, i + 1, sr + pos[i].r, sc + pos[i].c);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			l = n / 2;
			sumR = 0.0; sumC = 0.0;
			
			visited = new boolean[n];
			pos = new Pos[n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				pos[i] = new Pos(a, b);
				sumR += a;
				sumC += b;
			}
			
			answer = Double.MAX_VALUE;
			dfs(0, 0, 0.0, 0.0);
			answer = Math.sqrt(answer);
			
			sb.append(answer).append('\n');
		}
		System.out.println(sb.toString());
	}
}
