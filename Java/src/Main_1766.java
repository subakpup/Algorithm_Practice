import java.util.*;
import java.io.*;

public class Main_1766 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] ind;
	static List<ArrayList<Integer>> graph;

	private static void topo() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) {
			if (ind[i] == 0) pq.offer(i);
		}
		
		while (!pq.isEmpty()) {
			int cur = pq.poll();
			sb.append(cur).append(' ');
			
			for (int nxt : graph.get(cur)) {
				if (--ind[nxt] == 0) {
					pq.add(nxt);
				}
			}
		}
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
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			++ind[b];
		}
		
		topo();
		System.out.println(sb.toString());
	}

}
