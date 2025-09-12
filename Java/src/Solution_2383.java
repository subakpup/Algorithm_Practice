
/*
 * Solution_2383 점심 식사시간
 * 
 * # 문제 정리
 *  - N*N 크기 방에 사람들이 앉아 있다.
 *  - 점심을 먹기 위해 아래 층으로 내려가야 하는데, 최대한 빠른 시간 내에 내려가야 한다.
 *  - 이동 완료 시간은 모든 사람들이 계단을 내려가 아래층으로 이동을 완료한 시간이다.
 *  - 이동 시간: 계단 입구까지 이동 시간 + 계단을 내려가는 시간
 *  
 *  1. 계단 입구까지 이동 시간
 *    - 이동 시간(분) = | PR - SR | + | PC - SC |
 *  2. 계단을 내려가는 시간
 *    - 계단을 내려가는 시간은 계단 입구에 도착한 후부터 계단을 완전히 내려갈 때까지의 시간
 *    - 계단 입구에 도착하면, 1분 후 아래칸으로 내려 갈 수 있음
 *    - 계단 위에는 동시에 "최대 3명"까지만 올라가 있을 수 있음
 *    - 이미 계단을 3명이 내려가고 있는 경우, 그 중 한 명이 계단을 완전히 내려갈 때까지 계단 입구에서 대기
 *    - 계단 마다 길이 K가 주어지며, 계단에 올라간 후 내려가는 데 K분이 걸린다.
 *    
 *  - 모든 사람들이 계단을 내려가 이동이 완료되는 시간이 최소가 되는 시간을 출력
 *  
 * # 제약 사항
 *  - 4 <= N <= 10
 *  - 1 <= P <= 10
 *  - 계단: 2개
 *  - 2 <= K <= 10
 *  
 * # 아이디어
 *  - 사람, 계단의 정보 객체로 관리
 *  - 각 사람마다 (0, 1)번 계단에 도착하는 시간 저장
 *  - 부분 집합으로 사람들을 배치해 모든 시간 체크하기
 *  - 최소 힙으로 가장 빨리 나오는 사람 순으로 빼기
 * 
 */

import java.util.*;
import java.io.*;

public class Solution_2383 {
	
	// 사람
	static class Pos {
		int r, c;
		
		Pos (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	// 계단
	static class Stair {
		int r, c, l;
		
		Stair (int r, int c, int l) {
			this.r = r;
			this.c = c;
			this.l = l;
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static final int INF = (int) 1e9;
	
	static int n, p;
	static List<Pos> people;
	static List<Stair> stairs;
	static int[][] dist;
	static List<Integer> arr0, arr1;
	static int answer;
	
	// 부분 집합
	// 각 계단에 사람 배치
	private static void dfs(int idx) {
		if (idx == p) { // 배치가 완료 됐다면
			int t0 = simulate(arr0, stairs.get(0).l); // 계단에 가는 사람들 정보, 계단의 길이
			int t1 = simulate(arr1, stairs.get(1).l);
			int total = Math.max(t0, t1); // 더 오래 걸리는 쪽이 끝나야 최종 내려가는 시간이므로
			if (total < answer) answer = total; // 최솟값 갱신
			return;
		}
		
		arr0.add(dist[idx][0] + 1); // idx번째 사람이 0번 계단을 선택
		dfs(idx + 1); // 재귀
		arr0.remove(arr0.size() - 1); // 백트래킹
		
		arr1.add(dist[idx][1] + 1); // idx번째 사람이 1번 계단을 선택
		dfs(idx + 1); // 재귀
		arr1.remove(arr1.size() - 1); // 백트래킹
	}
	
	// 계단 내려가기 시뮬레이션
	private static int simulate(List<Integer> arrival, int l) {
		if (arrival.isEmpty()) return 0; // 공집합이면 0 return
		
		// 도착 시간 오름차순
		List<Integer> arr = new ArrayList<>(arrival);
		Collections.sort(arr);
		
		// 현재 계단 위에 있는 사람들의 "내려가기 종료 시각"을 담는 최소 힙
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		// 마지막으로 끝나는 시간
		int lastFinish = 0;
		
		// 모든 사람들 탐색
		for (int a : arr) {
			 // a 시각 이전에 이미 내려간 사람 비워주기
			while (!pq.isEmpty() && pq.peek() <= a) pq.poll();
			
			int start;
			if (pq.size() < 3) { // 계단에 3명이 다 차지 않았다면 a 시각에 바로 진입 가능
				start = a;
			}
			else { // 계단이 꽉 찼다면
				int firstFinish = pq.poll(); // 가장 먼저 내려갈 사람이 내려간 시각에 진입
				start = firstFinish;
			}
			
			int finish = start + l; // 현재 사람의 내려가기 종료 시각
			pq.offer(finish);
			if (finish > lastFinish) lastFinish = finish; // 마지막에 내려오는 사람 갱신
		}
		
		return lastFinish;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			people = new ArrayList<>();
			stairs = new ArrayList<>(2);
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int v = Integer.parseInt(st.nextToken());
					if (v == 1) people.add(new Pos(i, j)); // 사람인 경우
					else if (v > 1) stairs.add(new Stair(i, j, v)); // 계단인 경우
				}
			}
			
			// 각 사람 별로 계단까지의 맨해튼 거리 저장
			p = people.size();
			dist = new int[p][2];
			for (int i = 0; i < p; i++) {
				Pos pos = people.get(i);
				dist[i][0] = Math.abs(pos.r - stairs.get(0).r) + Math.abs(pos.c - stairs.get(0).c);
				dist[i][1] = Math.abs(pos.r - stairs.get(1).r) + Math.abs(pos.c - stairs.get(1).c);
			}
			
			// 0/1 번 계단을 선택하는 사람들을 담을 배열
			arr0 = new ArrayList<>();
			arr1 = new ArrayList<>();
			
			answer = INF;
			dfs(0);
			
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}
}
