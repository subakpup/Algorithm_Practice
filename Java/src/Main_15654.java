/*
 * Main_15654 N과 M (5)
 * 
 * # 문제 정리
 *  - N개의 자연수, 자연수 M
 *  - N개의 자연수 중에서 M개를 고른 수열
 *  - 중복되는 수열 X
 *  - 수열은 사전 순
 *  
 * # 아이디어
 *  - 숫자를 입력 받은 후에 sort를 이용해 정렬을 시켜야겠다 !
 */
import java.io.*;
import java.util.*;

public class Main_15654 {
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
				dfs(idx + 1);
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