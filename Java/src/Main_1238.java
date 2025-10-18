import java.util.*;
import java.io.*;

public class Main_1238 {
	
	static class Node implements Comparable<Node> {
		int idx, cost;
		
		Node (int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	static int n, m, x;
	static final int INF = 1_000_000_000;
	
	private static int[] dijkstra(List<ArrayList<Node>> g, int start) {
		int[] dist = new int[n+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			int u = cur.idx;
			int d = cur.cost;
			
			if (dist[u] < d) continue;
			
			for (Node nxt : g.get(u)) {
				int v = nxt.idx;
				int w = nxt.cost;
				
				if (dist[v] > dist[u] + w) {
					dist[v] = dist[u] + w;
					pq.add(new Node(v, dist[v]));
				}
			}
		}
		
		return dist;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		List<ArrayList<Node>> map = new ArrayList<>();
		List<ArrayList<Node>> rev = new ArrayList<>();
		for (int i = 0; i <= m; i++) {
			map.add(new ArrayList<>());
			rev.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map.get(u).add(new Node(v, w));
			rev.get(v).add(new Node(u, w));
		}
		
		int[] start = dijkstra(map, x);
		int[] end = dijkstra(rev, x);
		
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (start[i] == INF || end[i] == INF) continue;
			answer = Math.max(answer, start[i] + end[i]);
		}
		
		System.out.println(answer);
		
	}

}