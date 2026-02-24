import java.util.*;
import java.io.*;

public class Main_2563 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[][] arr = new boolean[100][100]; // 도화지 영역역
		
		int n = Integer.parseInt(br.readLine()); // n회 반복
		
		for (int I = 0; I < n; I++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // x 좌표
			int y = Integer.parseInt(st.nextToken()); // y 좌표
			
			// (x,y) ~ (x+10,y+10) 검은 색종이로 덮어 씌우기
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					arr[i][j] = true;
				}
			}
		}
		
		int answer = 0;
		
		// 정답 카운팅
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j]) answer++;
			}
		}
		
		System.out.println(answer);
	}
}
