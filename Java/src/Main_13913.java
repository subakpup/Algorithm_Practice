import java.util.*;
import java.io.*;

public class Main_13913 {
	static int n, k;
	static int[] dist, move;

	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(n);
		dist[n] = 1;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			if (cur == k) {
				System.out.println(dist[cur] - 1);
				path(cur);
				return;
			}
			
			if (0 <= cur + 1 && cur + 1 < 100001 && dist[cur + 1] == 0) {
				queue.add(cur + 1);
				dist[cur + 1] = dist[cur] + 1;
				move[cur + 1] = cur;
			}
			
			if (0 <= cur - 1 && cur - 1 < 100001 && dist[cur - 1] == 0) {
				queue.add(cur - 1);
				dist[cur - 1] = dist[cur] + 1;
				move[cur - 1] = cur;
			}
			
			if (0 <= cur * 2 && cur * 2 < 100001 && dist[cur * 2] == 0) {
				queue.add(cur * 2);
				dist[cur * 2] = dist[cur] + 1;
				move[cur * 2] = cur;
			}
		}
	}
	
	private static void path(int x) {
		Stack<Integer> stack = new Stack<>();
		int tmp = x;
		
		while (tmp != n) {
			stack.push(tmp);
			tmp = move[tmp];
		}
		stack.push(tmp);
		
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(' ');
		}
		System.out.println(sb.toString());
	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		dist = new int[100001];
		move = new int[100001];
		
		bfs();
	}

}
