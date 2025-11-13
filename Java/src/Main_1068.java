import java.io.*;
import java.util.*;

public class Main_1068 {
	static int n, s, d;
	static int[] tree;
	static boolean[] visited;
	static List<ArrayList<Integer>> graph;
	
	static int leaf = 0;
	
	private static void dfs(int cur) {
		boolean isLeaf = true;
		
		for (int nxt : graph.get(cur)) {
			if (!visited[nxt]) {
				isLeaf = false;
				visited[nxt] = true;
				dfs(nxt);
				visited[nxt] = false;
			}
		}
		
		if (isLeaf) ++leaf;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		tree = new int[n];
		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if (tree[i] == -1) s = i;
		}
		
		for (int i = 0; i < n; i++) {
			if (tree[i] == -1) continue;
			graph.get(tree[i]).add(i);
		}
		
		d = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		visited[d] = true;
		
		if (s == d) System.out.println(0);
		else {
			visited[s] = true;
			dfs(s);
			System.out.println(leaf);
		}
	}

}
