import java.io.*;

public class Main_10775 {
	static int G, P;
	static int[] p;
	static boolean[] parked;
	
	static int answer = 0;
	
	private static void make() {
		parked = new boolean[G+1];
		p = new int[G+1];
		
		for (int i = 1; i <= G; i++) {
			p[i] = i;
		}
	}
	
	private static int find(int x) {
		if (p[x] == x) return x;
		return p[x] = find(p[x]);
	}
	
	private static void union(int a, int b) {
		p[find(a)] = find(b);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		
		make();
		for (int i = 0; i < P; i++) {
			int g = Integer.parseInt(br.readLine());
			
			int x = find(g);
			if (x == 0) break;

			parked[x] = true;
			answer++;
			union(x, x-1);
		}
		
		System.out.println(answer);
	}

}
