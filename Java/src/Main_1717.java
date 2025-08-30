/*
 * Main_1717 집합의 표현 (골드 5)
 *  - 메모리: 52312
 *  - 시간: 324
 *  
 * # 문제 정리
 *  - 초기에 N + 1개의 집합 (0 ~ n)
 *  - 합집합 연산
 *  - 두 원소가 같은 집합에 포함되어 있는지 확인하는 연산
 * 
 * # 아이디어
 *  - Union-Find
 */
import java.util.*;
import java.io.*;

public class Main_1717 {
	static int n, m;
	static int[] p, s;
	static StringBuilder sb = new StringBuilder();
	
	/**
	 * 부모, 사이즈 배열 초기화
	 */
	private static void make() {
		p = new int[n+1];
		s = new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			p[i] = i; // 자신의 부모는 자신
			s[i] = 1; // 자신 혼자 있으니 1로 초기화
		}
	}
	
	/**
	 * find 메서드
	 * @param x
	 * @return 부모 원소
	 */
	private static int find(int x) {
		while (p[x] != x) { // 경로 압축
			p[x] = p[p[x]];
			x = p[x];
		}
		return x;
	}
	
	/**
	 * 합집합 연산
	 * @param 원소 a
	 * @param 원소 b
	 * @return 연산 결과
	 */
	private static boolean union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		
		if (ra == rb) return false;
		
		if (s[ra] < s[rb]) {
			int tmp = ra;
			ra = rb;
			rb = tmp;
		}
		
		p[rb] = ra;
		s[ra] += s[rb];
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 원소의 개수
		m = Integer.parseInt(st.nextToken()); // 연산의 개수
		
		make(); // 부모, 사이즈 배열 초기화
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken()); // 연산
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (cmd == 0) { // 합집합 연산
				union(a, b);
			} else { // 두 원소가 같은 집합에 포함되어 있는지 확인하는 연산
				sb.append(find(a) == find(b) ? "YES" : "NO").append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
