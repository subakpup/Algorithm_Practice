/*
 *  - 크기 n*n 도시
 *  - 도시는 1칸씩 나누어짐 (격자 그래프)
 *  - 각 칸: 빈 칸(0), 집(1), 치킨집(2)
 *  - 치킨 거리: 집과 가장 가까운 치킨집 사이의 거리
 *  - 도시의 치킨 거리: 모든 집의 치킨 거리의 합
 *  - 각 칸의 거리는 유클리드 거리
 *  - 치킨집의 개수는 최대 m개
 *  - 도시의 치킨 거리가 가장 작게되는 m개의 치킨집만 남기자
 *  - 치킨 거리 출력
 *  
 */

import java.io.*;
import java.util.*;

public class Main_15686 {
	
	static class Pos {
		int r, c;
		
		public Pos (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int n, m;
	static Pos[] selected;
	static int[][] map;
	static List<Pos> houses, chickens;
	
	static int answer = Integer.MAX_VALUE;
	
	private static void dfs(int depth, int start) {
		if (depth == m) {
			answer = Math.min(answer, chickenDist());
			return;
		}
		
		for (int i = start; i < chickens.size(); i++) {
			selected[depth] = chickens.get(i);
			dfs(depth + 1, i + 1);
		}
	}
	
	private static int chickenDist() {
		int total = 0;
		
		for (Pos house : houses) {
			int minDist = Integer.MAX_VALUE;
			
			for (Pos chicken : selected) {
				int curDist = Math.abs(house.r - chicken.r) + Math.abs(house.c - chicken.c);
				minDist = Math.min(minDist, curDist);
			}
			
			total += minDist;
		}
		
		return total;
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	map = new int[n][n];
    	houses = new ArrayList<>();
    	chickens = new ArrayList<>();
    	for (int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < n; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			if (map[i][j] == 1) houses.add(new Pos(i, j));
    			else if (map[i][j] == 2) chickens.add(new Pos(i, j));
    		}
    	}
    	
    	selected = new Pos[m];
    	
    	dfs(0, 0);
    	System.out.println(answer);
    }   	
}