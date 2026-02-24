import java.util.*;
import java.io.*;

public class Main_2473 {
	static int n;
	static long[] arr;
	static long[] answer = new long[3];
	
	static long diff = 3_000_000_000L;
	
	private static boolean solve(int idx) {
		int left = idx + 1, right = n - 1;
		
		while (left < right) {
			long sum = arr[idx] + arr[left] + arr[right];
			long abs = Math.abs(sum);
			
			if (abs < diff) {
				diff = abs;
				answer[0] = arr[idx];
				answer[1] = arr[left];
				answer[2] = arr[right];
				
				if (abs == 0L) return true;
			}
			
			if (sum > 0) right--;
			else left++;
		}
		
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		
		for (int i = 0; i < n-2; i++) {
			if (solve(i)) break;
		}
		
		for (long a : answer) System.out.print(a + " ");
	}

}
