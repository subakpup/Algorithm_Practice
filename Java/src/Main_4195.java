import java.io.*;
import java.util.*;

public class Main_4195 {
	static StringBuilder sb = new StringBuilder();
	static int f;
	static int[] p, s;
	static Map<String, Integer> friends;
	
	private static void makeSet() {
		p = new int[f * 2 + 1];
		s = new int[f * 2 + 1];
		for (int i = 1; i <= f * 2; i++) {
			p[i] = i;
			s[i] = 1;
		}
	}
	
	private static int find(int x) {
		if (p[x] == x) return x;
		return p[x] = find(p[x]);
	}
	
	private static int union(int a, int b) {
		int ra = find(a), rb = find(b);
		
		if (ra == rb) return s[ra];
		
		if (s[ra] < s[rb]) {
			int tmp = ra;
			ra = rb;
			rb = tmp;
		}
		
		p[rb] = ra;
		s[ra] += s[rb];
		return s[ra];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			f = Integer.parseInt(br.readLine());
			
			friends = new HashMap<>();
			makeSet();
			int idx = 0;
			
			for (int i = 0; i < f; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				
				if (!friends.containsKey(a)) {
					friends.put(a, ++idx);
				}
				
				if (!friends.containsKey(b)) {
					friends.put(b, ++idx);
				}
				
				int size = union(friends.get(a), friends.get(b));
				sb.append(size).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
