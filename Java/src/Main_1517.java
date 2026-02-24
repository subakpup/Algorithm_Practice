import java.util.*;
import java.io.*;

public class Main_1517 {
	
	static class Element implements Comparable<Element> {
		int idx, val;
		
		Element(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
		
		@Override
		public int compareTo(Element o) {
			return Integer.compare(this.val, o.val);
		}
	}
	
	static int n;
	static int[] tree;
	static Element[] elements;
	
	private static long solve(int start, int end, int node, int left, int right) {
		if (left > end || right < start) return 0L;
		if (left <= start && end <= right) return tree[node];
		
		int mid = (start + end) / 2;
		return solve(start, mid, node * 2, left, right) + solve(mid + 1, end, node * 2 + 1, left, right);
	}
	
	private static void update(int start, int end, int node, int idx, int val) {
		if (idx < start || idx > end) return;
		
		tree[node] += val;
		
		if (start == end) return;
		
		int mid = (start + end) / 2;
		update(start, mid, node * 2, idx, val);
		update(mid + 1, end, node * 2 + 1, idx, val);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		elements = new Element[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			elements[i] = new Element(i, Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(elements);
		
		int[] ranks = new int[n];
		int rank = 1;
		ranks[elements[0].idx] = rank;
		
		for (int i = 1; i < n; i++) {
			if (elements[i].val != elements[i-1].val) rank++;
			ranks[elements[i].idx] = rank;
		}
		
		tree = new int[n * 4];
		long answer = 0;
		
		for (int i = 0; i < n; i++) {
			int myRank = ranks[i];
			answer += solve(1, n, 1, myRank + 1, n);
			update(1, n, 1, myRank, 1);
		}
		
		System.out.println(answer);
	}

}
