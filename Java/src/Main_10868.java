import java.util.*;
import java.io.*;

public class Main_10868 {
	static int n, m;
	static int[] arr, tree;
	
	static final int INF = 1_000_000_001;
	
	private static int init(int start, int end, int node) {
		if (start == end) return tree[node] = arr[start];
		int mid = (start + end) / 2;
		return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
	}
	
	private static int min(int start, int end, int node, int left, int right) {
		if (left > end || right < start) return INF;
		if (left <= start && end <= right) return tree[node];
		
		int mid = (start + end) / 2;
		return Math.min(min(start, mid, node * 2, left, right), min(mid + 1, end, node * 2 + 1, left, right));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		tree = new int[n * 4];
		
		init(1, n, 1);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(min(1, n, 1, a, b)).append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
