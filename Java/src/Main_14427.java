import java.util.*;
import java.io.*;

public class Main_14427 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] arr, tree;
	
	static int idx = -1;
	static final int INF = 1_000_000_001;
	
	private static int init(int start, int end, int node) {
		if (start == end) return tree[node] = start;
		
		int mid = (start + end) / 2;
		return tree[node] = getIdx(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
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
	
	private static int getIdx(int idx1, int idx2) {
		if (idx1 == -1) return idx2;
		if (idx2 == -1) return idx1;
		
		return arr[idx1] <= arr[idx2] ? idx1 : idx2;
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
			int type = Integer.parseInt(st.nextToken());
			
			if (type == 1) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				update(1, n, 1, a, b);
			} else {
				sb.append(tree[1]).append('\n');
			}
		}
		
		System.out.println(sb.toString());
	}

}
