/*
 * Solution_6808 규영이와 인영이의 카드게임 (D3)
 * 
 * # 문제 정리
 *  - 규영이와 인영이는 1~18 수가 적힌 카드로 게임을 진행
 *  - 한 번의 게임에 9장씩 카드 배분
 *  - 총 9라운드
 *  - 한 라운드에 한 장씩 카드를 냄
 *  - 카드에 적힌 수 비교하여 점수 계산
 *  - 높은 수가 적힌 사람이 낸 카드의 점수를 모두 획득
 *  - 낮은 수가 적힌 사람은 아무 점수도 얻지 못함
 *  - 총점이 더 높은 사람이 우승
 *   - 총점이 같으면 무승부
 *  - 인영이가 카드를 내는 경우가 주어졌을 때
 *  - 규영이가 이기는 경우와 지는 경우 출력
 *  
 * # 아이디어
 *  - 규영이의 카드를 입력 받을 때, boolean 배열에 해당 번호를 저장해놓으면 인영이 카드를 저장할 때 좋을 것 같다!
 *  - 규영이의 카드는 고정시킨채, 인영이의 카드를 전부 살펴보며 -> 규영이가 클 때, 작을 때 모두 재귀
 */

import java.util.*;
import java.io.*;

public class Solution_6808 {
	static StringBuilder sb = new StringBuilder();
	static boolean[] used;
	static int[] in, gyu;
	static int win, lose;
	static boolean[] visited;
	
	public static void dfs(int depth, int gyuScore, int inScore) {
		if (depth == 9) { // 규영이의 카드를 모두 사용했다면 결과 비교
			if (gyuScore > inScore) win++;
			else if (gyuScore < inScore) lose++;
			return;
		}
		
		// 규영이의 카드를 인영이의 카드와 비교 시작 
		for (int i = 0; i < 9; i++) {
			if (!visited[i]) { // 탐색하지 않은 카드라면 탐색
				visited[i] = true;
				int gyuCard = gyu[depth]; // 규영이 카드 고정
				int inCard = in[i]; // 인영이 카드만 바꿔가며 비교
				if (gyuCard > inCard) { // 규영이가 이겼을 경우
					dfs(depth + 1, gyuScore + gyuCard + inCard, inScore);
				} else if (gyuCard < inCard) { // 인영이가 이겼을 경우
					dfs(depth + 1, gyuScore, inScore + gyuCard + inCard);
				}
				visited[i] = false; // 백트래킹
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // 테스트 케이스
		
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			gyu = new int[9]; // 규영이의 카드
			used = new boolean[19]; // 규영이가 받은 카드인지 확인하는 배열
			for (int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken()); // 규영이 카드
				used[gyu[i]] = true; // 수령 처리
			}
			
			// 인영이 카드
			in = new int[9];
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (!used[i]) { // 규영이가 갖고 있지 않으면
					in[idx++] = i;
				}
			}
			
			win = 0; // 승
			lose = 0; // 패
			visited = new boolean[9]; // 방문 여부
			dfs(0,0,0);
			
			sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}

}
