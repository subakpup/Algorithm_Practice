import java.io.*;

public class Main_10974 {
	static int n;
	static int[] arr, res;
	static boolean[] visited;
	
	private static void dfs(int length) {
		if (length == n) {
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[length] = i;
				dfs(length + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		visited = new boolean[n + 1];
		
		dfs(0);
	}

}
