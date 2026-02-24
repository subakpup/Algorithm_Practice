import java.util.*;
import java.io.*;

public class Main_4803 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] p;
	static boolean[] isCycle;
	
	static int num = 1;
	
	private static void make() {
		p = new int[n+1];
		isCycle = new boolean[n+1];
		
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}
	}
	
	private static int find(int x) {
		if (p[x] == x) return x;
		return p[x] = find(p[x]);
	}
	
	private static void union(int a, int b) {
		int ra = find(a), rb = find(b);

		if (ra != rb) {
			p[rb] = ra;
			
			if (isCycle[rb]) {
				isCycle[ra] = true;
			}
			
		} else {
			isCycle[ra] = true;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			if (n == 0 && m == 0) break;
			
			make();
			
			while (m-- > 0) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
				
			}
			
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (p[i] == i && !isCycle[i]) {
					cnt++;
				}
			}
			
			sb.append("Case ").append(num++).append(": ");
			if (cnt == 0) sb.append("No trees.\n");
			else if (cnt == 1) sb.append("There is one tree.\n");
			else sb.append("A forest of ").append(cnt).append(" trees.\n");
		}
		
		System.out.println(sb.toString());
	}

}
