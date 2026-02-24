import java.io.*;
import java.util.*;

public class Main_2512 {
	static int n, m, total, max;
	static int[] nums;
	
	private static void solve() {
		if (total <= m) {
			return;
		}
		
		while (true) {
			total = 0;
			--max;
			
			for (int i = 0; i < n; i++) {
				if (nums[i] > max) nums[i] = max;
			}
			
			for (int i = 0; i < n; i++) {
				total += nums[i];
			}
			
			if (total <= m) {
				return;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[n];
		total = 0; max = 0;
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			total += nums[i];
			max = Math.max(max, nums[i]);
		}
		
		m = Integer.parseInt(br.readLine());
		
		solve();
		
		System.out.println(max);
	}

}
