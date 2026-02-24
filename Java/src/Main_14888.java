import java.util.*;
import java.io.*;

public class Main_14888 {
	static int n, max, min;
	static int[] nums;
	static int[] oper = new int[4]; // +, -, *, /

	private static void dfs(int depth, int result) {
		if (depth == n) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (oper[i] > 0) {
				--oper[i];

				switch (i) {
				case 0:
					dfs(depth + 1, result + nums[depth]);
					break;
				case 1:
					dfs(depth + 1, result - nums[depth]);
					break;
				case 2:
					dfs(depth + 1, result * nums[depth]);
					break;
				case 3:
					if (result < 0)
						dfs(depth + 1, -(-result / nums[depth]));
					else
						dfs(depth + 1, result / nums[depth]);
					break;
				}

				++oper[i];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		dfs(1, nums[0]);

		System.out.println(max);
		System.out.println(min);
	}

}
