import java.util.*;
import java.io.*;

public class Main_2042 {
	static StringBuilder sb = new StringBuilder();
	static int N, M, K;
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
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		// 2^k >= N 만족하는 k 찾기
		int k = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
		int size = (int) Math.pow(2, k);
		
		tree = new long[size];
		
		init(1, N, 1);
		
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if (a == 1) {
				long dif = c - arr[b];
				arr[b] = c;
				update(1, N, 1, b, dif);
			} else {
				sb.append(sum(1, N, 1, b, (int) c)).append('\n');
			}
		}
		
		System.out.println(sb.toString());
	}

}
