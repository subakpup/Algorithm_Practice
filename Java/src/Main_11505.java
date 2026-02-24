import java.util.*;
import java.io.*;

public class Main_11505 {
	static int n, m, k;
	static long[] arr, tree;
	
	static final int MOD = 1_000_000_007;
	
	private static long init(int start, int end, int node) {
		if (start == end) return tree[node] = arr[start];
		int mid = (start + end) / 2;
		return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % MOD;
	}
	
	private static long update(int start, int end, int node, int idx, long val) {
		if (idx < start || idx > end) return tree[node];
		if (start == end) return tree[node] = val;
		int mid = (start + end) / 2;
		return tree[node] = (update(start, mid, node * 2, idx, val) * update(mid + 1, end, node * 2 + 1, idx, val)) % MOD;
	}
	
	private static long multiply(int start, int end, int node, int left, int right) {
		if (left > end || right < start) return 1;
		if (left <= start && end <= right) return tree[node];
		int mid = (start + end) / 2;
		return (multiply(start, mid, node * 2, left, right) * multiply(mid + 1, end, node * 2 + 1, left, right)) % MOD;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		tree = new long[n * 4];
		
		init(1, n, 1);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if (a == 1) {
				arr[b] = c;
				update(1, n, 1, b, c);
			} else {
				sb.append(multiply(1, n, 1, b, (int) c)).append('\n');
			}
		}
		
		System.out.println(sb.toString());
	}

}
