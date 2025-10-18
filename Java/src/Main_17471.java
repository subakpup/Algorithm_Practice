import java.util.*;
import java.io.*;

public class Main_17471 {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n;
	static int answer = Integer.MAX_VALUE;
	static int[] info;
	static List<ArrayList<Integer>> adj;
	static List<Integer> groupA, groupB;
	
	private static void dfs(int depth) {
		if (depth == n + 1) {
			if (connected(groupA) && connected(groupB)) {
				int sumA = 0;
				for (int v : groupA) sumA += info[v];
				int sumB = 0;
				for (int v : groupB) sumB += info[v];
				answer = Math.min(answer, Math.abs(sumA - sumB));
			}
			return;
		}
		
		
		groupA.add(depth);
		dfs(depth + 1);
		groupA.remove(groupA.size() - 1);
		
		groupB.add(depth);
		dfs(depth + 1);
		groupB.remove(groupB.size() - 1);
	}
	
	private static boolean connected(List<Integer> group) {
		if (group.isEmpty()) return false;
		
		Queue<Integer> queue = new ArrayDeque<>();
		List<Integer> connect = new ArrayList<>();
		queue.add(group.get(0));
		connect.add(group.get(0));
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int nxt : adj.get(cur)) {
				if (group.contains(nxt) && !connect.contains(nxt)) {
					connect.add(nxt);
					queue.add(nxt);
				}
			}
		}
		
		return group.size() == connect.size();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		info = new int[n+1];
		for (int i = 1; i <= n; i++) {
			info[i] = Integer.parseInt(st.nextToken());
		}
		
		adj = new ArrayList<>();
		for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= m; j++) {
				adj.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		groupA = new ArrayList<>(); groupB = new ArrayList<>();
		
		dfs(1);
		
		if (answer == Integer.MAX_VALUE) answer = -1;
		sb.append(answer);
		
		System.out.println(sb.toString());
	}

}
