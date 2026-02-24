import java.util.*;
import java.io.*;

public class Main_12015 {
	static int n;
	static int[] arr;
	static List<Integer> lis = new ArrayList<>();
	
	private static int binarySearch(int target) {
		int left = 0, right = lis.size();
		while (left < right) {
			int mid = (left + right) / 2;
			if (lis.get(mid) < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int x : arr) {
			if (lis.isEmpty() || lis.get(lis.size()-1) < x) {
				lis.add(x);
			} else {
				int pos = binarySearch(x);
				lis.set(pos, x);
			}
		}
		
		System.out.println(lis.size());
	}
}
