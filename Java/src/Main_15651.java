import java.io.*;
import java.util.*;

public class Main_15651 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] li;
	static boolean[] visited;
	
	private static void dfs(int idx) {
		if (idx == m) {
			for (int i : li) sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			li[idx] = i;
			dfs(idx + 1);
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	li = new int[m];
    	visited = new boolean[n+1];
    	
    	dfs(0);
    	System.out.println(sb.toString());
    }
}