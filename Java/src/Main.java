import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] arr, res;
	
	private static void binarySearch() {
		int left = 0, right = n-1, value = Integer.MAX_VALUE;
		res = new int[2];
		
		while (left < right) {
			int sum = arr[left] + arr[right];
			
			if (value > Math.abs(sum)) {
				value = Math.abs(sum);
				res[0] = arr[left];
				res[1] = arr[right];
				
				if (value == 0) return;
			}
			
			if (sum < 0) ++left;
			else --right;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		binarySearch();
		System.out.println(res[0] + " " + res[1]);
	}

}
