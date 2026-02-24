import java.io.*;

public class Main_2138 {
	static int n;
	static int[] target;
	
	private static int solve(int[] arr) {
		int cnt = 0;
		for (int i = 0; i < n-1; i++) {
			if (arr[i] != target[i]) {
				arr[i] = 1 - arr[i];
				arr[i+1] = 1 - arr[i+1];
				if (i < n-2) arr[i+2] = 1 - arr[i+2];
				++cnt;
			}
		}
		
		return arr[n-1] == target[n-1] ? cnt : Integer.MAX_VALUE;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		int[] arr1 = new int[n], arr2 = new int[n];
		String s = br.readLine();
		for (int i = 0; i < n; i++) {
			arr1[i] = s.charAt(i) - '0';
			arr2[i] = arr1[i];
		}
		
		arr2[0] = 1 - arr2[0];
		arr2[1] = 1 - arr2[1];
		
		target = new int[n];
		s = br.readLine();
		for (int i = 0; i < n; i++) {
			target[i] = s.charAt(i) - '0';
		}
		
		int cnt1 = solve(arr1), cnt2 = solve(arr2);
		if (cnt2 != Integer.MAX_VALUE) ++cnt2;
		
		int answer = Math.min(cnt1, cnt2);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
}