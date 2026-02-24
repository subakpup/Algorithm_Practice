import java.util.*;
import java.io.*;

public class Main_11286 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
			long aa = Math.abs((long) a);
			long bb = Math.abs((long) b);
			if (aa != bb) return Long.compare(aa, bb);
			return Integer.compare(a, b);
		});
		
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if (x == 0) sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
			else pq.offer(x);
		}
		System.out.println(sb.toString());
	}

}
