import java.util.*;
import java.io.*;

public class Main_9370 {
	
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
	static int n, m, t; // 교차로, 도로, 목적지 후보
	static int s, g, h; // 출발지, 지나야 하는 간선의 정보
	static List<ArrayList<Node>> graph; // 노드, 간선의 정보를 담은 그래프
	static int W; // g-h 가중치
	static int[] target; // 목적지 후보
	
	static final int INF = 1_000_000_000;
	
	private static void solve() {
		Arrays.sort(target);
		
		int[] distS = dijkstra(s);
		int[] distG = dijkstra(g);
		int[] distH = dijkstra(h);
		
		for (int i : target) {
			if (distS[i] == distS[g] + W + distH[i]) {
				sb.append(i).append(' ');
			} else if (distS[i] == distS[h] + W + distG[i]){
				sb.append(i).append(' ');
			}
		}
		
		sb.append('\n');
	}
	
	private static int[] dijkstra(int start) {
		int[] dist = new int[n+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0)); // 노드, 이동거리
		
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
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				graph.get(a).add(new Node(b, d));
				graph.get(b).add(new Node(a, d));
				if ((a == g && b == h) || (a == h && b == g)) W = d;
			}
			
			target = new int[t];
			for (int i = 0; i < t; i++) {
				target[i] = Integer.parseInt(br.readLine());
			}
			
			solve();
		}
		
		System.out.println(sb.toString());
	}

}
