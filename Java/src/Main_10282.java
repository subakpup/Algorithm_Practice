import java.util.*;
import java.io.*;

public class Main_10282 {
	
	static class Node implements Comparable<Node> {
		
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
	
	static int N, D, C;
	static List<ArrayList<Node>> graph;
	static int[] dist;
	static StringBuilder sb = new StringBuilder();
	
	static final int INF = 1_000_000_000;
	
	private static void dijkstra() {
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[C] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(C, 0));
		
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
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				graph.get(b).add(new Node(a, s));
			}
			
			dijkstra();
			
			int cnt = 0;
			int time = 0;
			
			for (int i = 1; i <= N; i++) {
				if (dist[i] != INF) {
					++cnt;
					time = Math.max(dist[i], time);
				}
			}
			
			sb.append(cnt).append(' ').append(time).append('\n');
		}
		System.out.println(sb.toString());
	}

}
