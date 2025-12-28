import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] ind;
	static List<ArrayList<Integer>> graph;
	
	private static void topo() {
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (ind[i] == 0) queue.add(i);
		}
		
		int cnt = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur).append('\n');
			++cnt;
			
			for (int nxt : graph.get(cur)) {
				if (--ind[nxt] == 0) {
					queue.add(nxt);
				}
			}
		}
		
		if (cnt != n) System.out.println(0);
		else System.out.println(sb.toString());
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
		
		ind = new int[n+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int before = Integer.parseInt(st.nextToken());
			
			for (int j = 1; j < num; j++) {
				int after = Integer.parseInt(st.nextToken());
				graph.get(before).add(after);
				ind[after]++;
				before = after;
			}
		}
		
		topo();
	}

}
