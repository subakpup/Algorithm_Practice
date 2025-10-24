import java.util.*;
import java.io.*;

public class Main_2075 {
	static int n;
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				pq.add(num);
			}
		}
		
		for (int i = 0; i < n - 1; i++) {
			pq.poll();
		}
		
		System.out.println(pq.poll());
	}
}
