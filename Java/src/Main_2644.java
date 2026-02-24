import java.util.*;
import java.io.*;

/**
 * 사람들은 1, 2, 3, …, n (1 ≤ n ≤ 100)의 연속된 번호로 각각 표시된다. 
 * 입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고, 
 * 둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다. 
 * 그리고 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다. 
 * 넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다. 
 * 이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.
 * 각 사람의 부모는 최대 한 명만 주어진다.
 */

public class Main_2644 {
	static int n, m, a, b;
	static boolean[] visited;
	static List<ArrayList<Integer>> graph;
	
	static int answer = -1;
	
	private static void dfs(int cur, int depth) {
		if (cur == b) {
			answer = depth;
			return;
		}
		
		visited[cur] = true;
		
		for (int next : graph.get(cur)) {
			if (!visited[next]) {
				dfs(next, depth + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
		
		visited = new boolean[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		dfs(a, 0);
		
		System.out.println(answer);
	}

}
