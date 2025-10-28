import java.util.*;
import java.io.*;

public class Main_17471 {
	static int n, answer;
	static int[] people;
	static List<ArrayList<Integer>> graph;
	static List<Integer> groupA, groupB;
	
	private static void dfs(int depth) {
		if (depth == n+1) {
			if (isConnect(groupA) && isConnect(groupB)) {
				int sumA = 0, sumB = 0;
				
				for (int a : groupA) {
					sumA += people[a];
				}
				
				for (int b : groupB) {
					sumB += people[b];
				}
				
				answer = Math.min(answer, Math.abs(sumA - sumB));
			}
			return;
		}
		
		groupA.add(depth);
		dfs(depth+1);
		groupA.remove(groupA.size()-1);
		
		groupB.add(depth);
		dfs(depth+1);
		groupB.remove(groupB.size()-1);
	}
	
	private static boolean isConnect(List<Integer> group) {
		if (group.isEmpty()) return false;
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(group.get(0));
		
		boolean[] visited = new boolean[n+1];
		visited[group.get(0)] = true;
		int cnt = 1;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int nxt : graph.get(cur)) {
				if (group.contains(nxt) && !visited[nxt]) {
					queue.add(nxt);
					visited[nxt] = true;
					++cnt;
				}
			}
		}
		
		return group.size() == cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		people = new int[n+1];
		for (int i = 1; i <= n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			for (int j = 0; j < t; j++) {
				graph.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		groupA = new ArrayList<>(); groupB = new ArrayList<>();
		answer = Integer.MAX_VALUE;
		dfs(1);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
}