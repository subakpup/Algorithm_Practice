import java.io.*;
import java.util.*;

public class Main_1504 {
	
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
	static int n, e, v1, v2;
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		int[] from1 = dijkstra(1);
		int[] fromV1 = dijkstra(v1);
		int[] fromV2 = dijkstra(v2);
		
		int path1, path2;
		
		// 1. 1 -> v1 -> v2 -> n
		if (from1[v1] == INF || fromV1[v2] == INF || fromV2[n] == INF) path1 = INF;
		else path1 = from1[v1] + fromV1[v2] + fromV2[n];

		// 2. 1 -> v2 -> v1 -> n
		if (from1[v2] == INF || fromV2[v1] == INF || fromV1[n] == INF) path2 = INF;
		else path2 = from1[v2] + fromV2[v1] + fromV1[n];
		
		int answer = Math.min(path1, path2);
		System.out.println(answer == INF ? -1 : answer);
	}

}
