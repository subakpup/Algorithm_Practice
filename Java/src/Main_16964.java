import java.util.*;
import java.io.*;

public class Main_16964 {
	static int n;
	static int[] target, seq;
	static boolean[] visited;
	static List<Integer> arr;
	static List<ArrayList<Integer>> graph;
	
	private static void dfs(int idx) {
		visited[idx] = true;
		arr.add(idx);
		
		for (int nxt : graph.get(idx)) {
			if (!visited[nxt]) {
				dfs(nxt);
			}
		}
		
	}
	
	private static boolean check() {
		if (arr.size() != n) return false;
		
		for (int i = 0; i < n; i++) {
			if (arr.get(i) != target[i]) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		target = new int[n];
		seq = new int[n+1];
		for (int i = 0; i < n; i++) {
			target[i] = Integer.parseInt(st.nextToken());
			seq[target[i]] = i;
		}
		
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph.get(i), (a, b) -> seq[a] - seq[b]);
		}
		
		visited = new boolean[n+1];
		arr = new ArrayList<>();
		
		dfs(1);
		
		System.out.println(check() ? 1 : 0);
	}

}
