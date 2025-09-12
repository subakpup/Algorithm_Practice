import java.util.*;
import java.io.*;

public class Main_1753 {
	
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
	
	static StringBuilder sb = new StringBuilder();
	static final int INF = (int) 1e9;
	static int v, e, start;
	static List<ArrayList<Node>> graph;
	static int[] dist;
	
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int u = cur.idx;
			int d = cur.cost;
			
			if (d > dist[u]) continue;
			
			for (Node nxt : graph.get(u)) {
				int v = nxt.idx;
				int w = nxt.cost;
				
				if (dist[v] > dist[u] + w) {
					dist[v] = dist[u] + w;
					pq.add(new Node(v, dist[v]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
	
		start = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= v; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v, w));
		}
		
		dist = new int[v+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		dijkstra();
		
		for (int i = 1; i <= v; i++) {
			sb.append((dist[i] == INF) ? "INF" : dist[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
