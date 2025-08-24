/*
 * Main_17281 야구 (골드4)
 * - 메모리: 12688KB
 * - 시간: 396ms
 * 
 * # 문제 정리
 *  - 1번 선수 4번 타자로 고정
 *  - 나머지 8명 배치하여 최대 득점 출력
 *  - 타순은 이닝이 넘어가도 유지
 *  - 3 아웃 시 종료
 *  - 타격 결과
 *   * 0: 아웃
 *   * 1: 1루타(모든 주자 1루씩 진루)
 *   * 2: 2루타(모든 주자 2루씩 진루)
 *   * 3: 3루타(모든 주자 3루씩 진루)
 *   * 4: 홈런(모든 주자 득점)
 *  - 각 이닝에 최소 한 명은 아웃
 * 
 * # 아이디어
 *  - 1번 선수를 제외한 나머지 선수들을 순열로 배치(8!)
 *  - 이닝 최대 50
 *  - 시간초과 걱정은 없으니, 완전 탐색으로 풀어도 되겠다 !
 */

import java.util.*;
import java.io.*;

public class Main_17281 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] order = new int[9];
	static boolean[] used = new boolean[9];
	static int[][] inning;
	static int answer = 0;
	
	/*
	 * 2번 ~ 8번 타자 조합
	 */
	private static void permutation(int p) {
		// 선수 배치가 완료되었다면, 최대 점수 갱신
		if (p == 9) {
			answer = Math.max(answer, simulate());
			return;
		}
		
		// 4번 타자는 1번으로 고정이므로 넘어감
		if (p == 3) {
			permutation(p+1);
			return;
		}
		
		// 2번타자부터 배치 시작
		for (int i = 1; i < 9; i++) {
			if (used[i]) continue;
			used[i] = true;
			order[p] = i;
			permutation(p+1);
			used[i] = false;
		}
		
	}
	
	private static int simulate() {
		int score = 0; // 현재 점수
		int idx = 0; // 현재 타자(다음 이닝에도 유지)
		
		for (int i = 0; i < n; i++) {
			int out = 0; // 아웃
			boolean b1 = false, b2 = false, b3 = false; // 1루, 2루, 3루
			
			while (out < 3) {
				int player = order[idx]; // 현재 선수
				int result = inning[i][player]; // 현재 이닝에서 결과
				
				if (result == 0) { // 아웃
					out++;
				} else if (result == 1) { // 안타
					if (b3) score++;
					b3 = b2;
					b2 = b1;
					b1 = true;
				} else if (result == 2) { // 2루타
					if (b3) score++;
					if (b2) score++;
					b3 = b1;
					b2 = true;
					b1 = false;
				} else if (result == 3) { // 3루타
					if (b3) score++;
					if (b2) score++;
					if (b1) score++;
					b3 = true;
					b2 = false;
					b1 = false;
				} else if (result == 4) { // 홈런
					if (b3) score++;
					if (b2) score++;
					if (b1) score++;
					b3 = false;
					b2 = false;
					b1 = false;
					score++;
				}
				idx = (idx + 1) % 9; // 다음 타자
			}
			
		}
		return score; // 끝나면 점수 리턴
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		inning = new int[n][9]; // 각 이닝에서 얻는 결과
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		order[3] = 0; // 1번 선수 4번 타자로 고정
		used[0] = true; // 사용 처리
		
		permutation(0); // 나머지 선수 조합
		System.out.println(answer);
	}

}
