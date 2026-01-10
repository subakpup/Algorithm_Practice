import java.util.*;
import java.io.*;

public class Main_1275 {
	static int n, q;
	static long[] arr, tree;

	private static long init(int start, int end, int node) {
		if (start == end) return tree[node] = arr[start];
		int mid = (start + end) / 2;
		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}
	
	private static long sum(int start, int end, int node, int left, int right) {
		if (left > end || right < start) return 0;
		
		if (left <= start && end <= right) return tree[node];
		
		int mid = (start + end) / 2;
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}
	
	private static void update(int start, int end, int node, int idx, long dif) {
		if (idx < start || idx > end) return;
		
		tree[node] += dif;
		if (start == end) return;
		
		int mid = (start + end) / 2;
		update(start, mid, node * 2, idx, dif);
		update(mid + 1, end, node * 2 + 1, idx, dif);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		tree = new long[n * 4];
		init(1, n, 1);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if (x > y) {
				int t = x;
				x = y;
				y = t;
			}
			
			sb.append(sum(1, n, 1, x, y)).append('\n');
			
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long dif = b - arr[a];
			arr[a] = b;
			update(1, n, 1, a, dif);
		}
		
		System.out.println(sb.toString());
	}

}
