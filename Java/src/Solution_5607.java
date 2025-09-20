/*
 * Solution_5607 조합 (D5)
 * 
 * # 문제 정리
 *  
 *  
 * # 아이디어
 *  - 페르마 소정리
 *  - (n! / r! * (n-r)!) mod p
 *    = (n! * (k! (n-k)!)^(-1)) mod p
 *    = ((n! mod p) * (k! (n-k)!)^(-1) mod p) mod p
 *  
 */

import java.util.*;
import java.io.*;

public class Solution_5607 {
	static StringBuilder sb = new StringBuilder();
	static int n, r;
	static long answer;
	
	static final long MOD = 1234567891L;
	static final int MAX = 1000000;
	static long[] factorial = new long[MAX+1];
	
	private static long fermat() {
		long a = factorial[n];
		long tmp = (factorial[r] * factorial[n-r]) % MOD;
		long b = pow(tmp, MOD - 2);
		return (a * b) % MOD;
	}
	
	private static long pow(long num1, long num2) {
		if (num2 == 0) return 1L;
		
		num1 %= MOD;
		long half = pow(num1, num2 / 2);
		long sq = (half * half) % MOD;
		
		if (num2 % 2 == 0) return sq;
		return (sq * num1) % MOD;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		factorial[0] = 1L % MOD;
		for (int i = 1; i <= MAX; i++) {
			factorial[i] = (factorial[i-1] * i) % MOD;
		}
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			answer = fermat();
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}
}
