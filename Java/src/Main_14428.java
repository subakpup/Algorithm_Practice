import java.util.*;
import java.io.*;

public class Main_14428 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] arr, tree;
	
	static final int INF = 1_000_000_001;
	
	private static int init(int start, int end, int node) {
		if (start == end) return tree[node] = start;
		int mid = (start + end) / 2;
		return tree[node] = getIdx(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
	}
	
	private static int getIdx(int idx1, int idx2) {
		if (idx1 == -1) return idx2;
		if (idx2 == -1) return idx1;
		return arr[idx1] <= arr[idx2] ? idx1 : idx2;
	}
	
	private static int update(int start, int end, int node, int idx, int val) {
		if (idx < start || idx > end) return tree[node];
		
		if (start == end) {
			arr[idx] = val;
			return tree[node] = idx;
		}
		
		int mid = (start + end) / 2;
		return tree[node] = getIdx(update(start, mid, node * 2, idx, val), update(mid + 1, end, node * 2 + 1, idx, val));
	}
	
	private static int getMin(int start, int end, int node, int left, int right) {
		if (left > end || right < start) return -1;
		
		if (left <= start && end <= right) return tree[node];
		
		int mid = (start + end) / 2;
		return getIdx(getMin(start, mid, node * 2, left, right), getMin(mid + 1, end, node * 2 + 1, left, right));
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
		
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			String cmd = st.nextToken();
			
			if (cmd.equals("1")) {
				int idx = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				
				update(1, n, 1, idx, val);
			} else {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				
				sb.append(getMin(1, n, 1, left, right)).append('\n');
			}
		}
		
		System.out.println(sb.toString());
	}

}
