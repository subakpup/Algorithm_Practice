/*
 * Main_1107 리모컨 (골드 4)
 *  - 메모리: 68620
 *  - 시간: 284
 *  
 * # 문제 정리
 *  - 리모컨 버튼을 너무 세게 누르는 바람에 일부 숫자 버튼이 고장 남
 *  - 리모컨에는 0부터 9까지 숫자, +와 - 버튼이 있다.
 *  - 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 존재
 *  - 채널 N으로 이동하려고 한다.
 *  - 어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는가?
 * 
 * # 아이디어
 *  - 전부 다 탐색하자
 *  - N이 최대 50만이다. 9가 고장난 경우 같이 더 많이 시도하는 경우가 생기므로 최대 100만까지 탐색을 진행했습니다.
 *  - 만약 4자리 채널로 이동하려 할 때, 최솟값은 4이다. (채널의 길이)
 *  - 그리고 만약 고장난 키 때문에 이동을 못하는 경우 |i - n|의 길이만큼 더해주면 이동할 수 있다.
 *  
 */

import java.util.*;
import java.io.*;

public class Main {
	static int n, m, answer;
	static boolean[] broken;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		// 고장난 버튼이 없을 경우
		if (m == 0) {
			// 글자 길이 vs 100(현재 채널) + 버튼 or - 버튼
			answer = Math.min(String.valueOf(n).length(), Math.abs(n - 100));
			System.out.println(answer);
			return;
		}
		
		// 고장난 버튼 배열
		broken = new boolean[10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			broken[Integer.parseInt(st.nextToken())] = true;
		}
		
		// 이동해야하는 횟수
		answer = Math.abs(n - 100);
		
		// 틀려는 채널이 100번일 경우 바로 출력
		if (answer == 0) {
			System.out.println(answer);
			return;
		}
		
		// 브루트 포스
		for (int i = 0; i <= 1000000; i++) {
			String target = String.valueOf(i); // i를 문자열로 변환
			boolean flag = true; // 현재 문자열에서 고장난 버튼이 존재하는지 판별하는 변수
			
			for (int j = 0; j < target.length(); j++) {
				if (broken[target.charAt(j) - '0']) { // 현재 채널의 문자열 중 고장난 버튼을 눌러야 하는 경우가 있다면
					flag = false; // false 후 종료
					break;
				} 
			}
			
			if (flag) { // 전부 버튼을 누를 수 있다면
				int cost = target.length() + Math.abs(i - n); // 문자열의 길이 + (현재 채널 - 찾으려는 채널)
				if (answer > cost) answer = cost; // 최솟값 갱신
			}
		}
		System.out.println(answer);
	}
}
