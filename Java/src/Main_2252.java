import java.util.*;
import java.io.*;

public class Main_2252 {
	static int n, m;
	static int[] ind;
	static List<Integer> res;
	static List<ArrayList<Integer>> graph;
	
	private static void init() {
		ind = new int[n+1];
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
	}
	
	private static void topology() {
		res = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		
		for (int i = 1; i <= n; i++) {
			if (ind[i] == 0) {
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			res.add(cur);
			
			for (int v : graph.get(cur)) {
				--ind[v];
				if (ind[v] == 0) {
					queue.add(v);
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		init();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			++ind[b];
		}
		
		topology();
		
		for (int v : res) System.out.print(v + " ");
	}

}
