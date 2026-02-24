import java.util.*;
import java.io.*;

public class Main_2696 {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int m;
	static PriorityQueue<Integer> minHeap, maxHeap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			minHeap = new PriorityQueue<>();
			maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
			m = Integer.parseInt(br.readLine());

			int cnt = 0;
			
			sb.append(m / 2 + 1).append('\n');
			for (int i = 0; i < m; i++) {
				if (i % 10 == 0)
					st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());

				if (minHeap.size() == maxHeap.size()) {
					maxHeap.offer(n);
				} else {
					minHeap.offer(n);
				}

				if (!minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
					int t1 = minHeap.poll();
					int t2 = maxHeap.poll();

					minHeap.offer(t2);
					maxHeap.offer(t1);
				}

				if (i % 2 == 0) {
					sb.append(maxHeap.peek()).append(' ');
					if (++cnt % 10 == 0) sb.append('\n');
				}
			}
			
			sb.append('\n');
		}

		System.out.println(sb.toString());
	}

}
