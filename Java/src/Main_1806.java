import java.util.*;
import java.io.*;

public class Main_1806 {
	static int n, s;
	static int[] arr;
	
	static final int INF = 1_000_000_000;
	
	private static int twoPointer() {
		int sum = 0, best = INF, left = -1;
		
		for (int right = 0; right < n; right++) {
			sum += arr[right];
			
			while (left < right && sum >= s) {
				sum -= arr[++left];
				best = Math.min(best, right - left + 1);
			}
			
		}
		
		return best == INF ? 0 : best;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(twoPointer());
	}

}