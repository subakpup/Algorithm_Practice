import java.util.*;
import java.io.*;

public class Main_13458 {
	static int n;
	static int[] a;
	static int b, c;
	
	public static long func() {
		long answer = n; // 시험장의 수만큼 ++
		for (int i = 0; i < n; i++) { // 모든 시험장 탐색
			a[i] -= b; // 총감독관이 감시하는 수 차감
			if (a[i] > 0) { // 총감독관이 감시할 수 있는 수를 초과할 경우
				if (a[i] % c == 0) { // 나누어 떨어지면
					answer += a[i] / c; // 부감독관이 감시할 수 있는 수만큼 배치
				} else {
					answer += a[i] / c + 1; // 나누어 떨어지지 않을 경우 부감독관이 감시할 수 있는 수 + 1만큼 배치
				}
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		System.out.println(func());
		
	}

}
