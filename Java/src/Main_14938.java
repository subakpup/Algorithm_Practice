import java.util.*;
import java.io.*;

public class Main_14938 {
	
	static class Node implements Comparable<Node>{
		
		int idx, cost;
		
		public Node (int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	static int n, m, r; // 지역 수, 수색범위, 길의 개수
	static int[] items; // 지역별 아이템 수
	static List<ArrayList<Node>> graph;
	static int answer = 0;
	static final int INF = 1_000_000_000;
	
	private static void solve() {
		for (int i = 1; i <= n; i++) {
			answer = Math.max(dijkstra(i), answer);
		}
	}
	
	private static int dijkstra(int start) {
		int[] dist = new int[n+1];
		Arrays.fill(dist, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (cur.cost > dist[cur.idx]) continue;
			
			for (Node nxt : graph.get(cur.idx)) {
				if (cur.cost + nxt.cost <= m && nxt.cost < dist[nxt.idx]) {
					dist[nxt.idx] = cur.cost + nxt.cost;
					pq.add(new Node(nxt.idx, cur.cost + nxt.cost));
				}
			}
		}
		
		int item = 0;
		for (int i = 1; i <= n; i++) {
			if (dist[i] <= m) {
				item += items[i];
			}
		}
		
		return item;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		items = new int[n+1];
		for (int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, l));
			graph.get(b).add(new Node(a, l));
		}
		
		solve();
		System.out.println(answer);
		
	}

}
