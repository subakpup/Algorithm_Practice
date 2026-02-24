import java.util.*;
import java.io.*;

public class Main_11657 {
	
	static class Edge {
		int u, v;
		long w;
		
		public Edge (int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static List<Edge> edges;
	
	static final long INF = Long.MAX_VALUE;
	
	private static void bellmanFord(int start) {
		long[] dist = new long[n+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				Edge edge = edges.get(j);
				
				if (dist[edge.u] != INF && dist[edge.v] > dist[edge.u] + edge.w) {
					dist[edge.v] = dist[edge.u] + edge.w;
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			Edge edge = edges.get(i);
			
			if (dist[edge.u] != INF && dist[edge.v] > dist[edge.u] + edge.w) {
				sb.append(-1).append('\n');
				return;
			}
		}
		
		for (int i = 2; i <= n; i++) {
			if (dist[i] == INF) {
				sb.append(-1).append('\n');
			} else {
				sb.append(dist[i]).append('\n');
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		edges = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges.add(new Edge(a, b, c));
		}
		
		bellmanFord(1);
		
		System.out.println(sb.toString());
	}

}
