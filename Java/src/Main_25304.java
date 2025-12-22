import java.util.*;
import java.io.*;

public class Main_25304 {
	static int x, n;
	static int sum = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		x = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sum += a * b;
		}
		
		if (x == sum) System.out.println("Yes");
		else System.out.println("No");
	}

}
