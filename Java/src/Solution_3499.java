/*
 * Solution_3499 퍼펙트 셔플 (D3)
 * 
 * # 문제 정리
 *  - 퍼펙트 셔플이란? 덱을 절반으로 나누고 나눈 것들에서 교대로 카드를 뽑아 새로운 덱을 만드는 것
 *  
 * # 아이디어
 *  - 반씩 쪼개 저장한 후, 배열 인덱스 별로 하나씩 넣어버리자
 *  
 */

import java.util.*;
import java.io.*;

public class Solution_3499 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static String[] arr1, arr2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr1 = new String[n];
			for (int i = 0; i < (n + 1) / 2; i++) {
				arr1[i] = st.nextToken();
			}
			
			arr2 = new String[n];
			for (int i = 0; i < n / 2; i++) {
				arr2[i] = st.nextToken();
			}
			
			sb.append("#" + tc + " ");
			int idx1 = 0, idx2 = 0;
			for (int i = 0; i < n; i++) {
				if (i % 2 == 0) sb.append(arr1[idx1++] + " ");
				else sb.append(arr2[idx2++] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
