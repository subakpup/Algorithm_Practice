import java.util.*;
import java.io.*;

public class Main_1202 {
	
	static class Jewelry implements Comparable<Jewelry>{
		int weight, price;
		
		public Jewelry (int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
		
		@Override
		public int compareTo(Jewelry o) {
			if (this.weight == o.weight) return Integer.compare(o.price, this.price);
			return Integer.compare(this.weight, o.weight);
		}

	}
	
	static int n, k;
	static int[] bags;
	static Jewelry[] jewelries;
	static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		jewelries = new Jewelry[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			jewelries[i] = new Jewelry(m, v);
		}
		Arrays.sort(jewelries);
		
		bags = new int[k];
		for (int i = 0; i < k; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);

		pq = new PriorityQueue<>(Collections.reverseOrder());
		
		long sum = 0;
		int idx = 0;
		
		for (int i = 0; i < k; i++) {
			while (idx < n && jewelries[idx].weight <= bags[i]) {
				pq.offer(jewelries[idx].price);
				++idx;
			}
			
			if (!pq.isEmpty()) {
				sum += pq.poll();
			}
		}
		
		System.out.println(sum);
	}

}
