import java.util.*;
import java.io.*;

public class Main_1976 {
	static int n, m;
	static int[] cmd;
	static int[][] graph;
	
	static int[] p, s;
	
	private static void make() {
		p = new int[n+1];
		s = new int[n+1];
		for (int i = 1; i <= n; i++) {
			p[i] = i;
			s[i] = 1;
		}
	}
	
	private static int find(int x) {
		if (p[x] == x) return x;
		return p[x] = find(p[x]);
	}
	
	private static boolean union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		
		if (ra == rb) return false;
		
		if (s[ra] < s[rb]) {
			int t = ra;
			ra = rb;
			rb = t;
		}
		
		p[rb] = ra;
		s[ra] += s[rb];
		return true;
	}
	
	private static void setRoot() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (graph[i][j] == 1) union(i, j);
			}
		}
	}
	
	private static void getAnswer() {
		int root = find(cmd[0]);
		for (int i = 1; i < m; i++) {
			if (find(cmd[i]) != root) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		graph = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		cmd = new int[m];
		for (int i = 0; i < m; i++) {
			cmd[i] = Integer.parseInt(st.nextToken());
		}
		
		make();
		setRoot();
		getAnswer();
	}

}
