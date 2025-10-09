import java.util.*;
import java.io.*;

public class Main_11279 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			switch (x) {
			case 0:
				if (pq.isEmpty()) {
					sb.append(0).append('\n');
				} else {
					sb.append(-pq.poll()).append('\n');
				}
				break;
			default:
				pq.add(-x);
			}
		}
		
		System.out.println(sb.toString());
	}

}
