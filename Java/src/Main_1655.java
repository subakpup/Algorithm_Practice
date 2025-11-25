import java.util.*;
import java.io.*;

public class Main_1655 {
	static int n;
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());
			if (maxHeap.size() == minHeap.size()) {
				maxHeap.offer(a);
			} else {
				minHeap.offer(a);
			}

			if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
				if (maxHeap.peek() > minHeap.peek()) {
					int tmp1 = maxHeap.poll();
					int tmp2 = minHeap.poll();

					minHeap.offer(tmp1);
					maxHeap.offer(tmp2);
				}
			}
			sb.append(maxHeap.peek()).append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
