import java.io.*;
import java.util.*;

public class Main_11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int answer = 0, tmp = 0;
		
		for (int num : arr) {
			answer += tmp + num;
			tmp += num;
		}
		
		System.out.println(answer);
	}

}
