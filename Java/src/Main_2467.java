import java.io.*;
import java.util.*;

public class Main_2467 {
	static int n, solution, left, right;
	static int[] li;
	
	private static void binarySearch(int l, int r) {
		
		while (l < r) {
			int tmp = li[l] + li[r];
			int abs = Math.abs(tmp);
			
			if (abs < solution) {
				solution = abs;
				left = l;
				right = r;
			}
			
			if (tmp == 0){
				left = l; right = r;
				break;
		    } else if (tmp < 0) {
				l++;
			} else {
				r--;
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		li = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			li[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(li);
		
		left = 0; right = n - 1;
		solution = Math.abs(li[left] + li[right]);
		binarySearch(0, n-1);
		
		System.out.println(li[left] + " " + li[right]);
	}

}
