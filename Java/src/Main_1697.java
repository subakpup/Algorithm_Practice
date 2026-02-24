import java.util.*;
import java.io.*;

public class Main_1697 {
	static int n, k;
	static int[] visited = new int[100001];
	
	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(n);
		visited[n] = 1;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			if (cur == k) return;
			
			if (cur + 1 <= 100000 && visited[cur + 1] == 0) {
				queue.add(cur + 1);
				visited[cur + 1] = visited[cur] + 1;
			}
			
			if (cur - 1 >= 0 && visited[cur - 1] == 0) {
				queue.add(cur - 1);
				visited[cur - 1] = visited[cur] + 1;
			}
			
			if (cur * 2 <= 100000 && visited[cur * 2] == 0) {
				queue.add(cur * 2);
				visited[cur * 2] = visited[cur] + 1;
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		bfs();
		
		System.out.println(visited[k] - 1);
	}

}
