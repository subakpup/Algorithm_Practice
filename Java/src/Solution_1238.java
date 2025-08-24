/*
 * Solution_1238 Contact (D4)
 * 
 * # 문제 정리
 *  - 1~100까지의 번호가 담긴 비상 연락망
 *  - 연락을 시작하는 당번부터 연락 시작
 *  - 가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람 출력
 *  
 * # 아이디어
 *  - BFS 탐색을 이용해 가장 마지막 레벨에 있는 사람들의 값을 이용하면 되겠다!
 *  - 탐색을 할 때 노드를 바로 빼내는 것이 아닌 같은 레벨의 사람들 위주로 탐색을 진행
 *  - 마지막 레벨에서 탐색을 마치면 그 사람들 중 가장 큰 값을 빼내자!
 *  - 인덱스 번호가 아닌 사람들의 번호가 랜덤으로 주어지므로 Map을 활용해 인접된 사람들을 입력하자
 */
import java.io.*;
import java.util.*;

public class Solution_1238 {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st; 
	static int n, s, answer; // 데이터의 길이, 시작점
	static Map<Integer, List<Integer>> map; // 단방향으로 연결된 연락망
	static boolean[] visited; // 방문 여부

	static int bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start); // 연락을 시작하는 당번
		visited[start] = true; // 방문 처리

		int last = start; // 가장 나중에 연락을 받는 사람(아무도 연락을 안 받았으니, 시작하는 사람으로 선언)

		while (!queue.isEmpty()) {
			int size = queue.size(); // 해당 레벨의 크기
			int max = -1; // 해당 레벨에서 가장 큰 번호
			
			for (int i = 0; i < size; i++) {
				int node = queue.poll();
				max = Math.max(max, node); // 당번과 최대 번호 비교 및 업데이트

				List<Integer> list = map.getOrDefault(node, Collections.emptyList()); // map에서 node의 정보가 있다면 리스트로 반환, 없다면 빈 배열 반환
				for (int value : list) { // 연결된 사람들 탐색
					if (0 < value && value <= 100 && !visited[value]) { // 방문하지 않은 노드가 있다면
						queue.add(value); // 값 추가
						visited[value] = true;
					}
				}
			}
			last = max; // 모든 레벨 탐색이 끝난 후 가장 큰 번호 업데이트
		}

		return last;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());

			map = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i += 2) {
				int from = Integer.parseInt(st.nextToken()); // 연락을 할 사람
				int to = Integer.parseInt(st.nextToken()); // 연락을 받는 사람

				List<Integer> list = map.get(from); // map에서 from이 연락을 할 수 있는 사람을 배열로 가져온다.
				if (list == null) { // 아무도 없다면
					list = new ArrayList<>(); // ArrayList 선언
					map.put(from, list); // map에 (from: ArrayList)로 값 추가
				}
				list.add(to); // key: from, value: [to]
			}

			visited = new boolean[101]; // 방문 여부
			answer = bfs(s); // 탐색
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb);
	}
}
