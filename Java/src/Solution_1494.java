
/*
 * Solution_1494 사랑의 카운슬러
 * 
 * # 문제 정리
 *  - 지렁이 친구 N마리를 소개팅 주선
 *  - 주선 방법은 임의의 지렁이 2마리 매칭 -> 한 지렁이에게 다른 지렁이가 있는 곳으로 이동
 *  - 지렁이들이 움직인 벡터의 합의 크기가 작기를 바란다.
 *    - 점 A -> 점 B: | (a, b) | = a * a + b * b;
 *  - 모든 지렁이들을 매칭시키고, 각 지렁이들이 움직인 벡터의 합이 최소가 되도록 출력
 *  
 * # 아이디어
 *  - 조합으로 다른 지렁이에게 이동할 지렁이를 구하자
 *  - 그러면 + 방향으로 이동하는 지렁이, - 방향으로 이동하는 지렁이 2분류로 나눌 수 있다.
 *  - 이 둘의 벡터 합을 구하게 되면: (+ 그룹 지렁이) - (- 그룹 지렁이) = (+ 그룹 지렁이) - ((전체) - (+그룹 지렁이))
 *    = (+ 그룹 지렁이) * 2 - (전체)가 전체의 벡터값이 됨
 *  - 입력 받을 때 전체 값을 미리 구하자 
 */

import java.util.*;
import java.io.*;

public class Solution_1494 {
	
	static class Pos {
		int r, c;
		
		Pos (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static int n, l;
	static Pos[] pos;
	static boolean[] visited;
	static long sumR, sumC;
	static long answer;
	
	private static void dfs(int idx, int start, long sr, long sc) {
		if (idx == l) { // l만큼 조합을 구했다면 벡터값을 구하자
			long tr = sr * 2 - sumR;
			long tc = sc * 2 - sumC;
			long total = tr * tr + tc * tc;
			if (answer > total) answer = total; // 최솟값 갱신
			return;
		}
		
		// 조합 구하기
		for (int i = start; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(idx + 1, i + 1, sr + pos[i].r, sc + pos[i].c);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			l = n / 2; // 전체 길이의 절반(그룹 절반을 구해야 하므로)
			
			// 지렁이들의 위치 저장
			pos = new Pos[n];
			sumR = 0L; sumC = 0L; // r좌표, c좌표 총합
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				pos[i] = new Pos(a, b);
				sumR += a;
				sumC += b;
			}
			
			answer = Long.MAX_VALUE; // 정답 초기화
			visited = new boolean[n]; // 지렁이 그룹 할당 여부 초기화
			dfs(0, 0, 0L, 0L);
			
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}
}
