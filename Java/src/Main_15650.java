import java.util.*;
import java.io.*;

public class Main_15650 {
	static int n, m;
	static List<Integer> arr = new ArrayList<>();
	static boolean[] visited;

	public static void dfs(int start) {
		if (arr.size() == m) {
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < n+1; i++) {
			if (!visited[i]) {
				arr.add(i);
				dfs(i + 1);
				arr.remove(arr.size() - 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visited = new boolean[n + 1];
		dfs(1); // 1부터 시작
	}

}
