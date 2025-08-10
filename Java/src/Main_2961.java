/*
 * Main_2961 도영이가 만든 맛있는 음식 (실버 2)
 *  - 메모리: KB
 *  - 시간: ms
 * 
 * # 문제 정리
 *  - N개의 재료
 *  - 신맛 S, 쓴맛 B
 *  - 신맛은 사용한 재료의 신맛의 "곱"
 *  - 쓴맛은 "합"
 *  - 신맛과 쓴맛의 차이를 작게 만들려고 한다
 *  - 재료는 적어도 하나
 *  - 
 */

import java.util.*;
import java.io.*;

public class Main_2961 {
	static int N;
	static int[][] taste;
	static int tmp = Integer.MAX_VALUE;
	
	public static void dfs(int depth, int s, int b) {
		if (depth == N) {
			if (s != 1 || b != 0) {
				tmp = Math.min(tmp, Math.abs(s - b));
			}
			return;
		}
		
		dfs(depth + 1, s, b);
		dfs(depth + 1, s * taste[depth][0], b + taste[depth][1]);
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		taste = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 1, 0);
		System.out.println(tmp);
	}

}
