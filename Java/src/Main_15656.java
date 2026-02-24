import java.io.*;
import java.util.*;

public class Main_15656 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] li, nums;
	
	private static void dfs(int idx) {
		
		if (idx == m) {
			for (int i : li) sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < n; i++) {
			li[idx] = nums[i];
			dfs(idx + 1);
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
		dfs(0);
		
		System.out.println(sb.toString());
	}

}
