import java.util.*;
import java.io.*;

public class Main_16953 {
	static long a, b;
	
	private static long bfs() {
		Queue<long[]> queue = new ArrayDeque<>();
		queue.add(new long[] {a, 1});
		
		while (!queue.isEmpty()) {
			long[] cur = queue.poll();
			long node = cur[0];
			long cnt = cur[1];
			
			if (node == b) return cnt;
			
			if (node * 2 <= b) {
				queue.add(new long[] {node * 2, cnt + 1});
			}
			
			if (node * 10 + 1 <= b) {
				queue.add(new long[] {node * 10 + 1, cnt + 1});
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		System.out.println(bfs());
	}

}
