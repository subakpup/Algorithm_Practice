/*
 * Solution_5643 키 순서
 * 
 * # 문제 정리
 *  - 1번부터 N번까지 번호가 붙여져 있는 학생들
 *  - 두 학생끼리 키를 비교한 결과의 "일부"가 주어짐
 *   - 학생들의 키는 모두 다르다고 가정
 *  - 자신의 키가 몇 번째인지 알 수 있는 학생들이 모두 몇 명인지 계산하여 출력
 *  
 * # 아이디어
 *  - 플로이드-워셜 알고리즘을 활용
 *  - (i -> k)를 알고 (k -> j)를 알 때, (i -> j)라는 것을 알 수 있다!
 */

import java.util.*;
import java.io.*;

public class Solution_5643 {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, m, answer;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			
			map = new int[n+1][n+1];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b] = 1;
			}
			
			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						if (map[i][k] == 1 && map[k][j] == 1) {
							map[i][j] = 1;
						}
					}
				}
			}
			
			answer = 0;
			for (int i = 1; i <= n; i++) {
				int tall = 0;
				int small = 0;
				for (int j = 1; j <= n; j++) {
					if (map[i][j] == 1) {
						tall++;
					} else if (map[j][i] == 1) {
						small++;
					}
				}
				if (tall + small == n-1) {
					answer++;
				}
			}
			
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

}
