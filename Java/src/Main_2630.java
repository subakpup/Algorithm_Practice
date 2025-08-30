/*
 * Main_2630 색종이 만들기 (실버2)
 *  - 메모리: 13192
 *  - 시간 100
 *  
 * # 문제 정리
 *  - 여러개의 정사각형 칸들로 이루어진 정사각형 모양의 종이
 *  - 정사각형들은 하얀색 or 파란색으로 칠해져 있다.
 *  - 일정한 규칙에 따라 잘라서 다양한 크기를 가진 정사각형 모양의 색종이를 만들려고 한다.
 *  - 전체 종이가 모두 같은 색으로 칠해져 있지 않으면 가로와 세로로 중간 부분을 잘라서 정확히 4등분으로 나눈다.
 *  - 이 과정을 모두 같은 색이 될 때까지 반복
 *  - 잘라진 하얀색 색종이와 파란색 색종이의 개수 출력
 *  
 * # 아이디어
 *  - 분할정복
 *  - 검사하여 모두 같으면 하얀색 or 파란색 카운팅
 *  - 다르다면 길이를 반으로 잘라 4등분한 공간을 탐색
 *  
 */

import java.util.*;
import java.io.*;

public class Main_2630 {
	static int n, white, blue;
	static int[][] map;

	private static void quad(int x, int y, int len) {
		int point = map[x][y];
		boolean flag = true;
		
		for (int r = x; r < x + len; r++) {
			for (int c = y; c < y + len; c++) {
				if (map[r][c] != point) {
					flag = false;
				}
			}
		}
		
		if (!flag) {
			int half = len / 2;
			quad(x, y, half);
			quad(x, y + half, half);
			quad(x + half, y, half);
			quad(x + half, y + half, half);
			return;
		} 
		
		if (point == 0) {
			white++;
		} else {
			blue++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		white = 0; blue = 0;
		quad(0, 0, n);
		System.out.println(white + "\n" + blue);
	}

}
