import java.util.*;
import java.io.*;

public class Main_13549 {
	static int n, k;
	static int[] visited;
	
	private static void bfs() {
		visited = new int[100001];
		Arrays.fill(visited, -1);
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(n);
		visited[n] = 0;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			if (cur == k) return;
			
			if (cur * 2 <= 100000 && visited[cur * 2] == -1) {
				visited[cur * 2] = visited[cur];
				queue.add(cur * 2);
			}
			
			if (cur - 1 >= 0 && visited[cur - 1] == -1) {
				visited[cur - 1] = visited[cur] + 1;
				queue.add(cur - 1);
			}
			
			if (cur + 1 <= 100000 && visited[cur + 1] == -1) {
				visited[cur + 1] = visited[cur] + 1;
				queue.add(cur + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		bfs();
		
		System.out.println(visited[k]);
	}

}
