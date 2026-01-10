import java.util.*;
import java.io.*;

public class Main_14438 {
	static int n, m;
	static int[] arr, tree;
	
	static final int INF = 1_000_000_001;
	
	private static int init(int start, int end, int node) {
		if (start == end) return tree[node] = arr[start];
		int mid = (start + end) / 2;
		return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
	}
	
	private static int update(int start, int end, int node, int idx, int val) {
		if (idx < start || idx > end) return tree[node];
		
		if (start == end) return tree[node] = val;
		
		int mid = (start + end) / 2;
		return tree[node] = Math.min(update(start, mid, node * 2, idx, val), update(mid + 1, end, node * 2 + 1, idx, val));
	}
	
	private static int min(int start, int end, int node, int left, int right) {
		if (left > end || right < start) return INF;
		
		if (left <= start && end <= right) return tree[node];
		
		int mid = (start + end) / 2;
		return Math.min(min(start, mid, node * 2, left, right), min(mid + 1, end, node * 2 + 1, left, right));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		tree = new int[n * 4];
		init(1, n, 1);
		
		StringBuilder sb = new StringBuilder();
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			String cmd = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (cmd.equals("1")) {
				arr[a] = b;
				update(1, n, 1, a, b);
			} else {
				sb.append(min(1, n, 1, a, b)).append('\n');
			}
		}
		
		System.out.println(sb.toString());
	}

}
