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
 *  
 */

import java.util.*;
import java.io.*;

public class Solution_6808 {
	static boolean[] used;
	static int[] in, gyu;
	static int win, lose;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			in = new int[9];
			for (int i = 0; i < 9; i++) {
				in[i] = Integer.parseInt(st.nextToken());
			}
			
			
			
			
		}
	}

}
