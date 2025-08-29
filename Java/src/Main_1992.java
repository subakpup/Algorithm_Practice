/*
 * Main_1992 쿼드트리 (실버 1)
 *  - 메모리: 13212KB
 *  - 시간: 76ms
 *  
 * # 문제 정리
 *  - 흰 점을 나타내는 0, 검은 점을 나타내는 1로만 이루어진 영상
 *  - 같은 숫자의 점들이 한 곳에 많이 몰려있으면, 쿼드 트리에서는 이를 압축할 수 있다.
 *  - 모두 0으로만 되어 있으면 압축 결과는 0이 되고, 모두 1로만 되어 있으면 1이 된다.
 *  - 만약 0과 1이 섞여 있으면 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 4개의 영상으로 압축
 *   - 이 4개의 영역을 압축한 결과를 차례대로 괄호 안에 묶어서 표현
 *  
 * # 아이디어
 *  - 현재 배열을 검사하여 모두 같은 숫자로만 이루어져 있다면 압축 결과 출력
 *  - 만약 다르다면, 4분할 하여 압축 결과를 출력
 *  - 재귀를 이용하자
 */

import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[][] map;
	
	private static void quad(int x, int y, int len) {
		int start = map[x][y]; // 비교할 점의 정보
		boolean flag = true; // 모두 같은 점인지 확인하는 변수
		for (int r = x; r < x + len; r++) {
			for (int c = y; c < y + len; c++) {
				if (map[r][c] != start) { // 비교할 점이 기존 점과 다르다면 false
					flag = false;
				}
			}
		}
		
		if (!flag) { // 다른 점이 있다면 재귀
			sb.append("("); // 압축 시 괄호 추가
			int half = len / 2;
			quad(x, y, half);
			quad(x, y + half, half);
			quad(x + half, y, half);
			quad(x + half, y + half, half);
			sb.append(")");
			return;
		}
		
		sb.append(start);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 변의 길이
		map = new int[n][n]; // 점들의 정보
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		quad(0, 0, n);

		System.out.println(sb.toString());
	}

}
