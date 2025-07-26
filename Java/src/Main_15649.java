import java.util.*;
import java.io.*;

/*
 * Main_15649_N과M(1)_함지수.java
 * 
 * 백트래킹 알고리즘의 기본 문제
 *  - 1부터 N까지의 수 중 중복 없이 M개를 고른 모든 경우 출력
 *  - M개를 고르되, 중복되는 수는 출력 X
 *  - visited 배열을 이용해서 방문하지 않은 경우에만 정답 배열에 추가
 *  - 값 추가 후 재귀
 *    - 만약 배열의 길이가 M과 같다면 배열 원소 출력
 *  - 재귀가 끝난 후 값 제거
 */

public class Main_15649 {
	// 클래스 변수 선언
	static int n, m;
	static ArrayList<Integer> arr = new ArrayList<>(); // 정답을 출력할 배열
	static boolean[] visited; // 방문 여부
	
	// 백트래킹을 수행할 함수
	public static void dfs() {
		// M개일 경우 원소 출력
		if (arr.size() == m) {
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		
		// 1부터 N까지 반복
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) { // 방문하지 않았을 경우
				visited[i] = true; // 방문 처리
				arr.add(i); // 값 추가
				dfs(); // 재귀
				arr.remove(arr.size() - 1); // 재귀 끝난 후 마지막 값 제거
				visited[i] = false; // 방문 처리 false
			}
		}
	}
	
	// 메인문
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n+1];
		
		dfs();
	}

}
