import java.util.*;
import java.io.*;

public class Main_2667 {
	static int n;
	static int[][] graph;
	static boolean[][] visited;
	static List<Integer> nums;
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	private static void bfs(int sr, int sc) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { sr, sc });
		visited[sr][sc] = true;
		int cnt = 1;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				if (graph[nr][nc] == 0 || visited[nr][nc]) continue;
				
				queue.add(new int[] { nr, nc });
				visited[nr][nc] = true;
				cnt++;
			}
		}
		
		nums.add(cnt);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				graph[i][j] = line.charAt(j) - '0';
			}
		}
		
		visited = new boolean[n][n];
		nums = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		Collections.sort(nums);
		
		System.out.println(nums.size());
		for (int num : nums) System.out.println(num);
	}

}
