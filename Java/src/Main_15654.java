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
import java.util.*;
import java.io.*;

public class Main_15654 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] arr;
	static boolean[] used;
	static List<Integer> nums;
	
	private static void dfs(int depth) {
		if (depth == m) {
			for (int a : arr) sb.append(a).append(' ');
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!used[i]) {
				used[i] = true;
				arr[depth] = nums.get(i);
				dfs(depth + 1);
				used[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		nums = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(nums);
		
		arr = new int[m];
		used = new boolean[n];
		
		dfs(0);
		
		System.out.println(sb.toString());
	}

}
