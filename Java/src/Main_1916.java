import java.util.*;
import java.io.*;

public class Main_1916 {
	
	static class Node implements Comparable<Node> {
		int idx, cost;
		
		Node (int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static final int INF = (int) 1e9;
	static int n, m, s, e;
	static int[] dist;
	static List<ArrayList<Node>> graph;
	
	private static int[] dijkstra(int start) {
		dist = new int[n+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			int u = cur.idx;
			int d = cur.cost;
			
			if (dist[u] < d) continue;
			
			for (Node nxt : graph.get(u)) {
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
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, c));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		int[] map = dijkstra(s);
		System.out.println(map[e]);
	}

}
