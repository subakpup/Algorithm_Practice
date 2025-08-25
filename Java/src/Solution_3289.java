/*
 * Solution_3289 서로소 집합 (D4)
 * 
 * # 문제 정리
 *  - 1부터 n까지 n개의 집합
 *  - 합집합 연산과 두 원소가 같은 집합에 포함되어 있는지 확인하는 연산 수행
 *  - n: 집합의 개수
 *  - m: 주어지는 연산의 개수
 *  - 0 a b: 합집합
 *  - 1 a b: 두 원소가 같은 집합에 포함되어 있는지
 * # 아이디어
 *  - 합집합 연산이 들어오면 Union
 *  - 같은 집합인지 검사할 땐 find(a), find(b)를 비교하면 되겠다 !
 */

import java.util.*;
import java.io.*;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] p, size;
	
	/*
	 * 부모, 크기 배열 초기화하는 메서드
	 */
	private static void make_set() {
		p = new int[n+1];
		size = new int[n+1];
		for (int i = 0; i <= n; i++) {
			p[i] = i;
			size[i] = 1;
		}
	}
	
	/*
	 * 부모 노드를 찾는 메서드
	 */
	private static int find(int x) {
		while (p[x] != x) { // 현재 값이 루트가 아닐 경우
			p[x] = p[p[x]]; // 부모 노드를 "부모의 부모" 노드로 업데이트
			x = p[x]; // 새로 할당한 부모를 현재 값으로 업데이트
		}
		return x;
	}
	
	/*
	 * a와 b를 하나의 집합으로 합치는 메서드
	 */
	private static void union(int a, int b) {
		int ra = find(a); // a의 루트 노드
		int rb = find(b); // b의 루트 노드
		
		if (ra == rb) return; // 둘의 부모가 같다면, 합칠 필요 없음
		
		// ra의 크기가 rb보다 같거나 클 경우로 합칠 것이기 때문에 역전 관계일 경우 swap
		if (size[ra] < size[rb]) {
			int tmp = size[ra];
			size[ra] = size[rb];
			size[rb] = tmp;
		}
		
		p[rb] = ra; // rb의 부모를 ra로 업데이트
		size[ra] += size[rb]; // ra의 크기를 rb만큼 더해준다.
		return;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 집합의 개수
			m = Integer.parseInt(st.nextToken()); // 연산의 개수
			
			make_set(); // parent, size 배열 초기화
			String answer = ""; // 정답 문자열
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken()); // 연산
				int a = Integer.parseInt(st.nextToken()); // 집합 a
				int b = Integer.parseInt(st.nextToken()); // 집합 b
				
				if (cmd == 0) { // 0일 경우 Union
					union(a, b);
				} else { // 1일 경우 각 집합의 루트 비교
					answer += find(a) == find(b) ? "1" : "0";
				}
			}
			
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

}
