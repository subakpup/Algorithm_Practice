import java.util.*;
import java.io.*;

public class Main_9095 {
	static StringBuilder sb = new StringBuilder();
	
	private static int dfs(int sum, int target) {
		if (sum > target) return 0;
		if (sum == target) return 1;
		
		int cnt = 0;
		
		cnt += dfs(sum + 1, target);
		cnt += dfs(sum + 2, target);
		cnt += dfs(sum + 3, target);
		
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int answer = dfs(0, n);
			sb.append(answer).append('\n');
		}
		System.out.println(sb.toString());
	}

}
