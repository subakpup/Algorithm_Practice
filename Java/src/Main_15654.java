/*
 * Main_15654 N과 M (5)
 * 
 * # 문제 정리
 *  - N개의 자연수, 자연수 M
 *  - N개의 자연수 중에서 M개를 고른 수열
 *  - 중복되는 수열 X
 *  - 수열은 사전 순
 *  
 * # 아이디어
 *  - 숫자를 입력 받은 후에 sort를 이용해 정렬을 시켜야겠다 !
 */
import java.util.*;
import java.io.*;

public class Main_15654 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] arr;
	static List<Integer> list = new ArrayList<>();
	static boolean[] visited;
	
	private static void dfs() {
		if (list.size() == m) { // 길이가 m과 같을 경우
			for (int v : list) {
				sb.append(v + " "); // 배열의 모든 값 출력
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) { // 방문하지 않은 원소일 경우
				visited[i] = true; // 방문 처리
				list.add(arr[i]); // 배열에 값 추가
				dfs(); // 재귀
				list.remove(list.size() - 1); // 백트래킹
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 입력 받을 수의 개수
		m = Integer.parseInt(st.nextToken()); // 출력할 수열의 길이
		
		arr = new int[n]; // n개의 수를 저장할 배열
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); // 정렬
		
		visited = new boolean[n]; // 방문 여부
		dfs();
		System.out.println(sb);
		
	}

}
