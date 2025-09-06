/*
 * Main_14891 
 *  - 메모리: 11692
 *  - 시간: 68
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
 *  
 */
import java.util.*;
import java.io.*;

public class Main_14891 {
	static int[][] cog = new int[4][8];
	static final int LEFT = 6;
	static final int RIGHT = 2;
	static int answer = 0;
	
	private static void simulate(int idx, int d) {
		int[] dir = new int[4];
		dir[idx] = d;
		
		for (int i = idx - 1; i >= 0; i--) {
			if (cog[i+1][LEFT] == cog[i][RIGHT]) break;
			dir[i] = -dir[i+1];
		}
		
		for (int i = idx + 1; i < 4; i++) {
			if (cog[i-1][RIGHT] == cog[i][LEFT]) break;
			dir[i] = -dir[i-1];
		}
		
		rotate(dir);
	}
	
	private static void rotate(int[] dir) {
		for (int i = 0; i < 4; i++) {
			if (dir[i] == 0) continue;
			
			Deque<Integer> queue = new ArrayDeque<>();
			
			for (int idx = 0; idx < 8; idx++) queue.add(cog[i][idx]);
			
			if (dir[i] == 1) queue.offerFirst(queue.pollLast());
			else if (dir[i] == -1) queue.offerLast(queue.pollFirst());
			
			for (int idx = 0; idx < 8; idx++) cog[i][idx] = queue.pollFirst();
		}
	}
	
	private static void scoring() {
		for (int i = 0; i < 4; i++) {
			if (cog[i][0] == 1) {
				answer += (1 << i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			String line = br.readLine();
			for (int j = 0; j < 8; j++) {
				cog[i][j] = line.charAt(j) - '0';
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			simulate(idx - 1, dir);
		}
		
		scoring();
		System.out.println(answer);
	}

}
