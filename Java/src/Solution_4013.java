
/*
 * Solution_4013 특이한 자석
 * 
 * # 문제 정리
 *  - 4개의 자석, 8개의 날 보유
 *  - N극이 0, S극이 1
 *  - 자석이 1칸 회전될 때, 붙어 있는 자석은 서로 붙어 있는 날의 자성과 "다를 경우"에만 인력에 의해 반대 방향으로 회전
 *  - 각 자석에 빨간색 화살표 위치에 있는 날의 자성이 N극이면 0점, S극이면 2^i점 획득
 *  - k번 자석을 회전시킨 후 점수 총합 출력
 *  
 * # 아이디어
 *  - 회전하려는 자석을 기준으로 오른쪽 왼쪽을 검사하자
 *  - 큐를 이용해 회전 구현
 */

import java.util.*;
import java.io.*;

public class Solution_4013 {
	static StringBuilder sb = new StringBuilder();
	static int k;
	static int[][] mag;

	static final int RIGHT = 2;
	static final int LEFT = 6;

	private static void dirSet(int n, int d) {
		int[] dir = new int[4];
		dir[n] = d;

		// 오른쪽 탐색
		for (int i = n + 1; i < 4; i++) {
			if (mag[i - 1][RIGHT] != mag[i][LEFT]) {
				dir[i] = -dir[i - 1];
			} else break;
		}

		// 왼쪽 탐색
		for (int i = n - 1; i >= 0; i--) {
			if (mag[i + 1][LEFT] != mag[i][RIGHT]) {
				dir[i] = -dir[i + 1];
			} else break;
		}

		rotate(dir);
	}

	private static void rotate(int[] dir) {
		// 회전
		for (int i = 0; i < 4; i++) {
			Deque<Integer> queue = new ArrayDeque<>();

			if (dir[i] == 0) continue; // 회전 안해도 되면 pass

			for (int idx = 0; idx < 8; idx++) queue.offer(mag[i][idx]); // 큐에 값 삽입

			if (dir[i] == 1) queue.offerFirst(queue.pollLast()); // 시계 방향
			else if (dir[i] == -1) queue.offerLast(queue.pollFirst()); // 반시계 방향

			for (int idx = 0; idx < 8; idx++) mag[i][idx] = queue.pollFirst(); // 회전 후 값 채워넣기
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			k = Integer.parseInt(br.readLine());

			// 자석 배치
			mag = new int[4][8];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					mag[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 자석 번호, 방향
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				dirSet(n - 1, d);
			}

			// 정답 계산
			int answer = 0;
			for (int i = 0; i < 4; i++) {
				if (mag[i][0] == 1) answer += (int) Math.pow(2, i);
			}
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}
}
