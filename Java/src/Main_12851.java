import java.util.*;
import java.io.*;

public class Main_12851 {
	static int n, k, INF;
	static int[] time, count;
	
	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(n);
		time[n] = 0;
		count[n] = 1;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			if (cur * 2 < INF) {
				if (time[cur * 2] == -1) {
					time[cur * 2] = time[cur] + 1;
					count[cur * 2] = count[cur];
					queue.add(cur * 2);
				} else if (time[cur * 2] == time[cur] + 1) {
					count[cur * 2] += count[cur];
				}
			}
			
			if (cur + 1 < INF) {
				if (time[cur + 1] == -1) {
					time[cur + 1] = time[cur] + 1;
					count[cur + 1] = count[cur];
					queue.add(cur + 1);
				} else if (time[cur + 1] == time[cur] + 1){
					count[cur + 1] += count[cur];
				}
			}
			
			if (cur - 1 > -1) {
				if (time[cur - 1] == -1) {
					time[cur - 1] = time[cur] + 1;
					count[cur - 1] = count[cur];
					queue.add(cur - 1);
				} else if (time[cur - 1] == time[cur] + 1){
					count[cur - 1] += count[cur];
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		INF = Math.max(n, k) * 2;
		
		time = new int[INF];
		count = new int[INF];
		Arrays.fill(time, -1);
		
		bfs();
		
		System.out.println(time[k]);
		System.out.println(count[k]);
	}

}
