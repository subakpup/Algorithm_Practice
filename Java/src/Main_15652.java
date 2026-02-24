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

import java.io.*;
import java.util.*;

public class Main_15652 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] li;
	static boolean[] visited;
	
	private static void dfs(int idx, int start) {
		if (idx == m) {
			for (int i : li) sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = start; i <= n; i++) {
			li[idx] = i;
			dfs(idx + 1, i);
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	li = new int[m];
    	
    	dfs(0, 1);
    	System.out.println(sb.toString());
    }
}
