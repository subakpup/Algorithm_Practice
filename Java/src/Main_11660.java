/*
 * Main_11660 구간 합 구하기 5 (실버 1)
 * - 메모리: 132016KB
 * - 시간: 676ms
 * 
 * # 문제 정리
 *  - N*N 사이즈 배열
 *  - (x1, y1) ~ (x2, y2) 합 출력
 *  
 * # 아이디어
 *  - 누적합을 이용해 원하는 크기의 합을 구해주면 된다!
 * 
 */
import java.util.*;
import java.io.*;

public class Main_11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 배열의 길이
		int m = Integer.parseInt(st.nextToken()); // 반복 횟수
		
		// 배열에 수 집어넣기
		int[][] arr = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 좌표마다 누적합 구하기
		int[][] prefix = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				prefix[i][j] = arr[i][j] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1]; 
			}
		}
		
		// 결과
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			// 좌표 받기
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// 누적합 결과
			int answer = prefix[x2][y2] - prefix[x1-1][y2] - prefix[x2][y1-1] + prefix[x1-1][y1-1];
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
