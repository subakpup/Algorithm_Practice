/*
 * Main_1197 최소 스패닝 트리 (골드 4)
 *  - 메모리: 48928
 *  - 시간: 540
 *  
 * # 문제 정리
 *  - 그래프가 주어졌을 때, 그 그래프의 최소 신장 트리를 구하라
 *  
 * # 아이디어
 *  - 크루스칼 알고리즘
 */

import java.util.*;
import java.io.*;

public class Main_1197 {
	static int v, e;
	static int[] p, s;
	
	// 간선 정보를 저장할 객체 생성
	static class Edge implements Comparable<Edge> {
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	private static void make() {
		p = new int[v + 1];
		s = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			p[i] = i;
			s[i] = 1;
		}
	}
	
	private static int find(int x) {
		while (p[x] != x) {
			p[x] = p[p[x]];
			x = p[x];
		}
		return x;
	}
	
	private static boolean union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		
		if (ra == rb) return false;
		
		if (s[ra] < s[rb]) {
			int tmp = ra;
			ra = rb;
			rb = tmp;
		}
		
		p[rb] = ra;
		s[ra] += s[rb];
		return true;
	}
	
	private static long kruskal(Edge[] edges) {
		Arrays.sort(edges);
		make();
		
		long mstCost = 0;
		int usedEdge = 0;
		
		for (Edge e : edges) {
			if (union(e.from, e.to)) {
				mstCost += e.weight;
				if (++usedEdge == v - 1) break;
			}
		}
		
		return mstCost;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		Edge[] edges = new Edge[e];
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(a, b, c);
		}
		
		System.out.println(kruskal(edges));
	}

}
