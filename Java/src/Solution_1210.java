/*
 * Solution_1210 Ladder1 (D4)
 * 
 * # 문제 정리
 *  - 어느 사다리를 고르면 X표시에 도착하는가
 * 
 * # 아이디어
 *  - 도착지점부터 시작해서 올라가면 금방 구할 수 있을 것 같다!
 *  
 */

import java.util.*;
import java.io.*;

public class Solution_1210 {
	static StringBuilder sb = new StringBuilder();
	static int[][] board;
	static int[] dx = new int[] {1, -1};
	static int target;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			board = new int[10][10];
			for (int i = 0; i < 10; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 10; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			target = -1;
			for (int i = 0; i < 10; i++) {
				if (board[9][i] == 2) target = i;
			}
			
			while (true) {
				
			}
		}
	}

}
