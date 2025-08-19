/*
 * Solution_1873 상호의 배틀필드 (D3)
 # 문제 정리
 - 맵 구성
    .: 평지
    *: 벽돌 벽
    #: 강철 벽
    -: 물
    ^, v, <, >: 전차(위, 아래, 왼쪽, 오른쪽)

 - 커맨드
    U: 위로 이동
    D: 아래로 이동
    L: 왼쪽으로 이동
    R: 오른쪽으로 이동
    S: 발사
 
 - 전차는 항상 범위 내
 - 물로 이동 불가
 - 포탄 발사: 벽에 충돌 or 맵 밖으로 나갈 때까지 직진
 - 벽에 충돌 시
  - 벽돌 벽: 파괴
  - 강철 벽: 파괴 불가
 */

import java.io.*;
import java.util.*;

public class Solution {
	static int h, w, n; // 높이, 너비, 커맨드 수
	static String[][] field; // 게임 맵
	static String direction; // 전차의 방향
	static String[] command; // 커맨드 
	static int r, c; // 전차의 위치
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 게임 맵 설정
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			field = new String[h][w];
			for (int i = 0; i < h; i++) {
				String[] strArray = br.readLine().split("");
				for (int j = 0; j < w; j++) {
					field[i][j] = String.valueOf(strArray[j]);
				}
			}
			
			// 커맨드 입력
			n = Integer.parseInt(br.readLine());
			command = br.readLine().split("");
			direction = null;
			
			// 전차의 위치
			r = -1;
			c = -1;
			
			// 전차의 위치 탐색
			out:
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (field[i][j].equals("^") || field[i][j].equals("v") || field[i][j].equals("<") || field[i][j].equals(">")) {
						r = i;
						c = j;
						direction = field[i][j];
						break out; // 반복문 모두 종료
					}
				}
			}
			
			// 입력 받은 커맨드대로 행동 시작
			for (String cmd : command) {
				if (cmd.equals("U")) { // 위로 이동
					if (0 < r && field[r-1][c].equals(".")) {
						field[r][c] = ".";
						r--;
						field[r][c] = "^";
						direction = "^";
					} else { // 평지가 아닐 경우 위치만 재조정
						field[r][c] = "^";
						direction = "^";
					}
				}
				else if (cmd.equals("D")) { // 아래로 이동
					if (r < (h - 1) && field[r+1][c].equals(".")) {
						field[r][c] = ".";
						r++;
						field[r][c] = "v";
						direction = "v";
					} else { // 평지가 아닐 경우 위치만 재조정
						field[r][c] = "v";
						direction = "v";
					}
				}
				else if (cmd.equals("L")) { // 왼쪽으로 이동
					if (0 < c && field[r][c-1].equals(".")) {
						field[r][c] = ".";
						c--;
						field[r][c] = "<";
						direction = "<";
					} else { // 평지가 아닐 경우 위치만 재조정
						field[r][c] = "<";
						direction = "<";
					}
				}
				else if (cmd.equals("R")) { // 오른쪽으로 이동
					if (c < (w-1) && field[r][c+1].equals(".")) {
						field[r][c] = ".";
						c++;
						field[r][c] = ">";
						direction = ">";
					} else { // 평지가 아닐 경우 위치만 재조정
						field[r][c] = ">";
						direction = ">";
					}
				}
				else if (cmd.equals("S")) { // 포탄 발사
					if (direction.equals("^")) { // 위쪽으로 발사
						for (int i = r; i >= 0; i--) {
							if (field[i][c].equals("*")) { // 벽돌일 경우 파괴
								field[i][c] = ".";
								break;
							} else if (field[i][c].equals("#")) { // 강철 벽일 경우 포탄 제거
								break;
							}
						}
					}
					else if (direction.equals(">")) { // 오른쪽으로 발사
						for (int i = c; i < w; i++) {
							if (field[r][i].equals("*")) {
								field[r][i] = ".";
								break;
							} else if (field[r][i].equals("#")) {
								break;
							}
						}
					}
					else if (direction.equals("<")) { // 왼쪽으로 발사
						for (int i = c; i >= 0; i--) {
							if (field[r][i].equals("*")) {
								field[r][i] = ".";
								break;
							} else if (field[r][i].equals("#")) {
								break;
							}
						}
					}
					else if (direction.equals("v")) { // 아래쪽으로 발사
						for (int i = r; i < h; i++) {
							if (field[i][c].equals("*")) {
								field[i][c] = ".";
								break;
							} else if (field[i][c].equals("#")) {
								break;
							}
						}
					}
				}
			}
			
			// 디버깅 코드
//			for (String[] line : field) {
//				for (String s : line) {
//					System.out.print(s);
//				}
//				System.out.println();
//			}
			
			sb.append("#" + tc + " ");
			for (String[] line : field) {
				for (String r : line) {
					sb.append(r);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
