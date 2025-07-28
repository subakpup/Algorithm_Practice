/*
 * Main_15652_N과M(4)_함지수.java
 * 
 * 백트래킹 알고리즘의 기본 문제
 *  - 자연수 N과 M
 *  - 1부터 N까지 자연수 중에서 M개를 고른 수열
 *  - 중복 수 가능
 *  - 고른 수열은 비내림차순
 *  - 방문 여부를 따질 필요 없이, 시작 지점을 지정해 해당 자연수부터 시작하는 방식으로 구현
 */

import java.util.*;
import java.io.*;

public class Main_15652 {
	// 클래스 변수 선언
	static int n, m;
	static ArrayList<Integer> arr = new ArrayList<>();
	
	// 백트래킹 함수
	public static void dfs(int start) {
		// 배열의 크기가 M일 경우 출력
		if (arr.size() == m) {
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		
		// 시작 지점(처음엔 1)부터 N까지 반복
		for (int i = start; i <= n; i++) {
			arr.add(i);
			dfs(i); // 다음 숫자도 i 이상만 가능
			arr.remove(arr.size()-1); // 백트래킹
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dfs(1); // 1부터 시작
	}

}
