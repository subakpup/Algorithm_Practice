import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] li, nums;
	static boolean[] visited;
	
	private static void dfs(int idx) {
		if (idx == m) {
			for (int i : li) sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				li[idx] = nums[i];
				dfs(idx);
				visited[i] = false;
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(br.readLine());
    	nums = new int[n];
    	for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());
    	Arrays.sort(nums);
    	
    	li = new int[m];
    	visited = new boolean[n];
    	
    	dfs(0);
    	System.out.println(sb.toString());
    }
}