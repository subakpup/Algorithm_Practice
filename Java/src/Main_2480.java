import java.util.*;
import java.io.*;

public class Main_2480 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int answer;
		
		if (a == b && b == c) {
			answer = 10000 + a * 1000;
		} else if (a == b || a == c) {
			answer = 1000 + a * 100;
		} else if (b == c) {
			answer = 1000 + b * 100;
		} else {
			answer = Math.max(a, Math.max(b, c)) * 100;
		}
		
		System.out.println(answer);
	}

}
