import java.util.*;
import java.io.*;

public class Main_1654 {
	static int k, n;
	static long l = 1, r = 0;
	static int[] arr;
	
	private static long solve() {
		while (l <= r) {
			long mid = (l + r) / 2;
			
			int cnt = 0;
			for (int a : arr) {
				cnt += a / mid;
			}
			
			if (cnt < n) r = mid - 1;
			else l = mid + 1;
		}
		
		return r;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[k];
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			r = Math.max(arr[i], r);
		}
		
		System.out.println(solve());
	}

}
