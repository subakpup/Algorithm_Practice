import java.io.*;
import java.util.*;

public class Main_11779 {
	
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
	
	static StringBuilder sb = new StringBuilder();
	static int n, m, start, end;
	static int[] root;
	static List<ArrayList<Node>> graph;
	
	static final int INF = 1_000_000_000;
	
	private static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		int[] dist = new int[n+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		root = new int[n+1];
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int u = cur.idx, d = cur.cost;
			
			if (dist[u] < d) continue;
			
			for (Node nxt : graph.get(u)) {
				int v = nxt.idx, w = nxt.cost;
				
				if (dist[v] > dist[u] + w) {
					dist[v] = dist[u] + w;
					root[v] = u;
					pq.add(new Node(v, dist[u] + w));
				}
			}
		}
		
		return dist[end];
	}
	
	private static void trace() {
		List<Integer> path = new ArrayList<>();
		
		int idx = end;
		while (idx != 0) {
			path.add(idx);
			idx = root[idx];
		}
		
		sb.append(path.size()).append('\n');
		for (int i = path.size()-1; i >= 0; i--) sb.append(path.get(i)).append(' ');
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
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		sb.append(dijkstra()).append('\n');
		trace();
		
		System.out.println(sb.toString());
	}

}
