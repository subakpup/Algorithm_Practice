
/*
 * Solution_5658 보물상자 비밀번호
 * 
 * # 문제 정리
 *  - 각 변에 16진수 숫자가 적혀 있는 보물 상자
 *  - 시계방향 회전 가능, 회전할 때마다 숫자가 한 칸씩 회전
 *  - 보물 상자에 적힌 숫자로 만들 수 있는 모든 수 중, K번째로 큰 수를 10진수로 만든 수가 비밀번호
 *  - 비밀번호 출력
 *  
 * # 아이디어
 *  - 입력 받은 문자열을 이어 붙여 2배로 만들면 회전을 구현하지 않아도 된다.
 *  - TreeSet을 이용해서 내림차순으로 저장하자
 *  - 이렇게 하면 k번째 값을 찾기 쉽다.
 */

import java.util.*;
import java.io.*;

public class Solution_5658 {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, k, answer;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 숫자 길이
			k = Integer.parseInt(st.nextToken()); // K번째 큰 값
			
			String tmp = br.readLine();
			String s = tmp + tmp; // 입력 받은 문자열을 이어 붙이자
			int len = n / 4; // 한 변의 길이
			
			Set<Integer> set = new TreeSet<>(Comparator.reverseOrder()); // 내림차순 TreeSet
			
			for (int i = 0; i < len; i++) { // 한 변의 길이
				for (int start = i; start < i + n; start += len) { // i번부터 시작하여 i+n까지 len 간격으로 4번 탐색하자
					String sub = s.substring(start, start + len); // 시작 지점부터 한 변의 길이만큼 잘라서
					int val = Integer.parseInt(sub, 16); // 16진수로 변환
					set.add(val); // set에 추가(중복 제거)
				}
			}
			
			int cnt = 0;
			for (int v : set) {
				if (++cnt == k) answer = v; // k번째가 되면 값 저장
			}
			
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

}
