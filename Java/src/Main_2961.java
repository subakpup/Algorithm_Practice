/*
 * Main_2961 도영이가 만든 맛있는 음식 (실버 2)
 *  - 메모리: 11508KB
 *  - 시간: 68ms
 * 
 * # 문제 정리
 *  - N개의 재료
 *  - 신맛 S, 쓴맛 B
 *  - 신맛은 사용한 재료의 신맛의 "곱"
 *  - 쓴맛은 "합"
 *  - 신맛과 쓴맛의 차이를 작게 만들려고 한다
 *  - 재료는 적어도 하나
 *  - 최솟값 출력
 *  
 * # 아이디어
 *  - 재귀를 이용해 완전 탐색
 *  - 해당 재료를 사용하는 경우, 사용하지 않는 경우 모두 탐색
 *  - 깊이가 N에 도달한 경우 최솟값 비교하여 리턴
 */

import java.util.*;
import java.io.*;

public class Main_2961 {
	static int N; // 재료의 수
	static int[][] taste; // 신맛, 쓴맛을 담을 배열
	static int answer = Integer.MAX_VALUE; // 결과
	
	public static void dfs(int depth, int s, int b) {
		if (depth == N) { // 깊이가 N에 도달한 경우
			if (s != 1 || b != 0) { // 아무것도 선택하지 않은 경우 제외
				answer = Math.min(answer, Math.abs(s - b)); // 최솟값 비교
			}
			return;
		}
		
		dfs(depth + 1, s, b); // 해당 재료를 선택하지 않은 경우
		dfs(depth + 1, s * taste[depth][0], b + taste[depth][1]); // 해당 재료를 선택한 경우
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 재료 배열에 삽입
		taste = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 1, 0); // 신맛은 곱해야 하므로 1로 시작, 쓴맛은 더해야 하므로 0부터 시작
		System.out.println(answer);
	}

}
