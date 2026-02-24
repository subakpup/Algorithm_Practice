import java.io.*;
import java.util.*;

public class Main_1978 {
	public static boolean isPrime(int x) {
		if (x <= 1) return false;
		
		for (int i = 2; i < x; i++) {
			if (x % i == 0) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (isPrime(tmp)) answer++;
		}
		
		System.out.println(answer);
		
		
	}

}
