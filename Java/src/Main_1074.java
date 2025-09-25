import java.io.*;
import java.util.*;

public class Main_1074 {
	static int n, r, c;
	
	private static int func(int n, int r, int c) {
		if (n == 0) {
			return 0;
		}
		
		int mid = (int) Math.pow(2, n-1);
		
		if (r < mid && c < mid) {
			return func(n-1, r, c);
		} else if (r < mid && c >= mid) {
			return mid * mid + func(n-1, r, c - mid);
		} else if (r >= mid && c < mid) {
			return 2 * mid * mid + func(n-1, r - mid, c);
		} else {
			return 3 * mid * mid + func(n-1, r - mid, c - mid);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		System.out.println(func(n, r, c));
	}

}
