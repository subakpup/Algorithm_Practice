import java.util.*;
import java.io.*;

public class Main_2357 {
	static int n, m;
	static int[] arr, minTree, maxTree;
	
	static final int INF = 1_000_000_001;
	
	// 0: min, 1: max
	private static int init(int[] tree, int type, int start, int end, int node) {
		if (start == end) return tree[node] = arr[start];
		
		int mid = (start + end) / 2;
		if (type == 0) {
			return tree[node] = Math.min(init(tree, type, start, mid, node * 2), init(tree, type, mid + 1, end, node * 2 + 1));
		} else {
			return tree[node] = Math.max(init(tree, type, start, mid, node * 2), init(tree, type, mid + 1, end, node * 2 + 1));
		}
	}
	
	private static int solve(int[] tree, int type, int start, int end, int node, int left, int right) {
		if (left > end || right < start) return type == 0 ? INF : 0;
		if (left <= start && end <= right) return tree[node];
		int mid = (start + end) / 2;
		
		if (type == 0) return Math.min(solve(tree, type, start, mid, node * 2, left, right), solve(tree, type, mid + 1, end, node * 2 + 1, left, right));
		else return Math.max(solve(tree, type, start, mid, node * 2, left, right), solve(tree, type, mid + 1, end, node * 2 + 1, left, right));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		maxTree = new int[n * 4];
		minTree = new int[n * 4];
		
		init(minTree, 0, 1, n, 1);
		init(maxTree, 1, 1, n, 1);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(solve(minTree, 0, 1, n, 1, a, b)).append(' ').append(solve(maxTree, 1, 1, n, 1, a, b)).append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
