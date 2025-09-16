import java.util.*;
import java.io.*;

public class Main_2609 {
	static int num1, num2;
	
	private static int gcd(int a, int b) {
		while (b != 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		return a;
	}
	
	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		num1 = Integer.parseInt(st.nextToken());
		num2 = Integer.parseInt(st.nextToken());
		
		System.out.println(gcd(num1, num2));
		System.out.println(lcm(num1, num2));
	}
}
