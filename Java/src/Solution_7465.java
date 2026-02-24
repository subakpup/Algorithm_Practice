/*
 * Solution_7465 창용 마을 무리의 개수 (D4)
 * 
 * # 문제 정리
 *  - 1부터 n까지 번호가 붙여진 n명의 사람
 *  - 두 사람이 서로 아는 관계이거나 몇 사람을 거쳐서 알 수 있는 관계라면,
 *   >> 하나의 무리라고 한다.
 *  - 마을에 몇 개의 무리가 존재하는가?
 *  
 * # 아이디어
 *  - 같은 집합일 경우 합집합 연산
 *  - 초기 무리는 n이므로 합집합 연산을 할 때마다 1씩 감소시키면 총 집합의 개수를 구할 수 있겠다 !
 *  
 */

import java.util.*;
import java.io.*;

public class Solution_7465 {
	static StringBuilder sb = new StringBuilder();
	static int n, m, answer;
	static int[] p, size;
	
	/*
	 * 부모, 크기 배열 초기화
	 * 정답 변수 초기화
	 */
	private static void make_set() {
		p = new int[n+1];
		size = new int[n+1];
		answer = n;
		
		for (int i = 0; i <= n; i++) {
			p[i] = i; // 자신의 부모는 자신으로 초기화
			size[i] = 1; // 크기는 1(자신만 있기 때문)
		}
	}
	
	/*
	 * 현재 값의 부모를 찾기 위한 메서드
	 */
	private static int find(int x) {
		while (p[x] != x) {
			p[x] = p[p[x]];
			x = p[x];
		}
		return x;
	}
	
	/*
	 * a 집합과 b 집합을 합치는 메서드
	 */
	private static void union(int a, int b) {
		int ra = find(a); // a의 루트
		int rb = find(b); // b의 루트
		
		if (ra == rb) return; // 루트가 같다면(같은 집합이면) 합치지 않아도 됨
		
		if (size[ra] < size[rb]) {
			int tmp = ra;
			ra = rb;
			rb = tmp;
		}
		
		/*
		 * rb를 ra의 집합으로 합침
		 */
		p[rb] = ra; // rb의 부모를 ra로 설정
		size[ra] += size[rb]; // ra의 크기를 rb만큼 증가
		answer--; // 집합 2개가 하나로 합쳐졌으므로 정답 변수 1 감소
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			make_set();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b); // a 집합과 b 집합 합치기
			}
			
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

}
