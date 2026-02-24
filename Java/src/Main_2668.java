import java.util.*;
import java.io.*;

public class Main_2668 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] arr;
	static boolean[] visited;
	static List<Integer> result;
	
	private static void dfs(int start, int cur) {
		visited[cur] = true;
		int nxt = arr[cur];
		
		if (!visited[nxt]) dfs(start, nxt);
		else if (nxt == start) result.add(start);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n+1];
			dfs(i, i);
		}
		
		Collections.sort(result);
		sb.append(result.size()).append('\n');
		for (int r : result) sb.append(r).append('\n');
		
		System.out.println(sb.toString());
	}

}
