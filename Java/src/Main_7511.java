import java.util.*;
import java.io.*;

public class Main_7511 {
	static StringBuilder sb = new StringBuilder();
	static int n, k, m;
	
	static int[] p, s;
	
	private static void make() {
		p = new int[n];
		s = new int[n];
		
		for (int i = 0; i < n; i++) {
			p[i] = i;
			s[i] = 1;
		}
	}
	
	private static int find(int x) {
		if (p[x] == x) return x;
		return p[x] = find(p[x]);
	}
	
	private static boolean union(int a, int b) {
		int ra = find(a), rb = find(b);
		
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			
			n = Integer.parseInt(br.readLine());
			k = Integer.parseInt(br.readLine());
			
			make();
			
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			
			sb.append("Scenario ").append(tc).append(":").append('\n');
			
			m = Integer.parseInt(br.readLine());
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				if (find(u) == find(v)) {
					sb.append(1);
				} else {
					sb.append(0);
				}
				
				sb.append('\n');
			}
			
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
