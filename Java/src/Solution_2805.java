import java.util.*;
import java.io.*;

public class Solution_2805 {

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // 테스트 케이스
		
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine()); // 농장의 크기
			
			// 농작물 선언
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = line.charAt(j) - '0'; // 문자열 하나를 기준으로 split
				}
			}
			
			// 정답 추출 로직
			int answer = 0;
			for (int i = 0; i < n; i++) { // 농장의 크기만큼 반복
				int v = Math.abs(n/2 - i); // 각 행의 시작 인덱스
				for (int j = v; j < n - v; j++) { // n-v까지 수확
					answer += arr[i][j];
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}

}
