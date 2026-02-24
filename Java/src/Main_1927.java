import java.io.*;
import java.util.*;

public class Main_1927 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0) {
				pq.add(x);
			} else {
				Integer cur = pq.poll();
				System.out.println(cur == null ? 0 : cur);
			}
		}
	}

}
