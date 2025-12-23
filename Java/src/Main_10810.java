import java.util.*;
import java.io.*;

public class Main_10810 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] bucket;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		bucket = new int[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			for (int j = a; j <= b; j++) {
				bucket[j] = c;
			}
		}
		
		for (int i = 1; i <= n; i++) sb.append(bucket[i]).append(' ');
		
		System.out.println(sb.toString());
	}

}
