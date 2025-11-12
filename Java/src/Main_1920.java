import java.util.*;
import java.io.*;

public class Main_1920 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static boolean[] used;
	static Set<Integer> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		used = new boolean[m];
		for (int i = 0; i < m; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if (set.contains(cur)) used[i] = true;
		}
		
		for (boolean u : used) {
			if (u) sb.append(1).append('\n');
			else sb.append(0).append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
