import java.util.*;
import java.io.*;

public class Main_28277 {
	static StringBuilder sb = new StringBuilder();
	static int n, q;
	static int[] p, s;
	static Map<Integer, Set<Integer>> map;
	
	private static void union(int a, int b) {
		Set<Integer> setA = map.get(a);
		Set<Integer> setB = map.get(b);
		
		if (setA.size() < setB.size()) {
			map.put(a, setB);
			map.put(b, setA);
			
			Set<Integer> t = setA;
			setA = setB;
			setB = t;
		}
		
		setA.addAll(setB);
		setB.clear();
	}
	
	private static void size(int a) {
		sb.append(map.get(a).size()).append('\n');
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		map = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < m; j++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			
			map.put(i, set);
		}
		
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			
			if (cmd == 1) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			} else {
				int a = Integer.parseInt(st.nextToken());
				size(a);
			}
		}
		
		System.out.println(sb.toString());
	}

}
