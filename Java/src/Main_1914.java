import java.io.*;
import java.math.BigInteger;

public class Main_1914 {
	public static void hanoi(int n, int dep, int via, int end) { // 원판 갯수, 시작 지점, 경유 지점, 도착 지점
		if (n == 1) { // 원판이 하나 남은 경우
			System.out.println(dep + " " + end);	// 1번 -> 3번(가장 작은 원판만 남았기 때문)
		} else {
			hanoi(n-1, dep, end, via); 				// n-1개: 1번 -> 3번 -> 2번
			System.out.println(dep + " " + end); 	// 가장 큰 원판: 1번 -> 3번
			hanoi(n-1, via, dep, end);				// n-1개: 2번 -> 1번 -> 3번
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		BigInteger cnt = new BigInteger("2").pow(n).subtract(BigInteger.ONE); // 하노이 탑의 총 이동횟수 2^n - 1
		System.out.println(cnt);
		
		// n이 20 이하일 때만 이동 경로 표시
		if (n <= 20) {
			hanoi(n, 1, 2, 3);
		}
	}

}
