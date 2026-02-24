/*
 * Solution_3421 수제 버거 장인 (D5)
 * 
 * # 문제 정리
 *  - 사용할 수 있는 재료는 1번부터 N번까지 총 N가지
 *  - i번 재료와 j번 재료가 서로 궁합이 맞지 않는다면 동시에 사용 불가
 *  - 궁합이 맞지 않는 재료들로 M개 쌍에 대한 정보가 주어짐
 *  - 만들 수 있는 버거의 종류 출력
 *  - 두 버거가 정확하게 같은 종류의 재료들을 사용한다면 두 버거는 같은 종류
 *  
 * # 아이디어
 *  - 백트래킹을 이용해 모든 경우의 수를 고려하면 될 거 같다!
 *  - 모든 조합을 고려하고 나면 갯수 + 1
 *  - 조합이 되지 않는 재료들은 선택을 하면 안 되기 때문에 플래그를 이용
 */

import java.util.*;
import java.io.*;

public class Solution_3421 {
	static StringBuilder sb = new StringBuilder(); // 정답 저
	static int n, m; // 재료의 개수, 어울리지 않는 조합
	static boolean[][] worst; // 궁합이 맞지 않는 재료를 저장할 배열
	static int cnt; // 만들 수 있는 햄버거의 개수
	
	public static void dfs(int idx, boolean[] used) {
		// 기저 조건: 전부 탐색을 끝내면 카운팅
		if (idx > n) {
			cnt++;
			return;
		}
		
		// 선택할 수 있는 재료인가?
		boolean select = true;
		
		// 현재 인덱스에 있는 재료와 어울리지 않는 재료가 있는가?
		for (int i = 1; i <= n; i++) {
			if (used[i] && worst[idx][i]) { // 버거에 들어 있는가? and 조합이 안 되는 재료가 있으면
				select = false; // 선택 X
				break;
			}
		}
		
		// idx번 재료가 조합이 되는 재료라면
		if (select) {
			used[idx] = true; // 사용 선언
			dfs(idx + 1, used); // 다음 재료 탐색
			used[idx] = false; // 탐색 종료 후 선택 해제(백트래킹)
		}
		
		// idx번 재료 선택 X
		dfs(idx + 1, used);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			worst = new boolean[n+1][n+1];
			for (int i = 1; i <= m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				worst[a][b] = true;
				worst[b][a] = true;
			}
			
			cnt = 0;
			dfs(1, new boolean[n+1]);
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

}
