/*
 * Main_2805 나무 자르기 (실버 2)
 *  - 메모리: 167824
 *  - 시간: 460
 *  
 * # 문제 정리
 *  - 나무 M미터 필요
 *  - 높이 H를 지정해 나무 절단 가능
 *  - 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값 출력
 *  
 * # 아이디어
 *  - 이분탐색
 *  - 높이를 최소 1부터 최대 높이까지 설정하여 탐색
 *  - 원하는 나무 길이보다 길 경우 left 값 증가
 *  - 원하는 나무 길이보다 짧을 경우 right값 감소
 */

import java.util.*;
import java.io.*;

public class Main_2805 {
	static int n;
	static long m;
	static int[] trees;
	
	/**
	 * 이분 탐색
	 * @param left // 절단기 최소 높이
	 * @param right // 절단기 최대 높이
	 * @return // 절단기에 설정할 수 있는 높이의 최댓값
	 */
	private static int binarySearch(int left, int right) {
		long length; // 높이
		while (left <= right) {
			int mid = (left + right) / 2; // 중앙값
			length = 0L;
			
			for (int tree : trees) {
				if (tree > mid) {
					length += tree - mid; // 절단기보다 높이 위치한 나무의 길이
				}
			}
			
			if (length >= m) { // 원하는 값(m) 보다 많을 때 left값 증가시켜 길이 조정
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Long.parseLong(st.nextToken());
		
		int l = 1; // 절단기 최소 높이
		int r = 0; // 절단기 최대 높이
		st = new StringTokenizer(br.readLine());
		trees = new int[n]; // 나무들의 높이 정보
		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if (trees[i] > r) r = trees[i]; // 최대 높이 갱신
		}
		
		System.out.println(binarySearch(l, r));
	}

}
