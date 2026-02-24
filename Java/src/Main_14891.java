import java.util.*;
import java.io.*;

public class Main_14891 {
	static int k;
	static int[][] cogs;
	
	static final int RIGHT = 2;
	static final int LEFT = 6;
	
	static int score = 0;
	
	private static void simulate(int n, int d) {
		int[] dir = new int[4];
		dir[n] = d;
		
		for (int i = n-1; i >= 0; i--) {
			if (cogs[i][RIGHT] != cogs[i+1][LEFT]) {
				dir[i] = -dir[i+1];
			}
		}
		
		for (int i = n+1; i < 4; i++) {
			if (cogs[i][LEFT] != cogs[i-1][RIGHT]) {
				dir[i] = -dir[i-1];
			}
		}
		
		rotation(dir);
	}
	
	private static void rotation(int[] dir) {
		for (int i = 0; i < 4; i++) {
			if (dir[i] == 0) continue;
			
			Deque<Integer> cog = new ArrayDeque<>();
			for (int j = 0; j < 8; j++) cog.add(cogs[i][j]);
			
			if (dir[i] == 1) {
				cog.addFirst(cog.pollLast());
			} else {
				cog.addLast(cog.pollFirst());
			}
			
			for (int j = 0; j < 8; j++) {
				cogs[i][j] = cog.pollFirst();
			}
		}
	}
	
	private static void scoring() {
		for (int i = 0; i < 4; i++) {
			if (cogs[i][0] == 1) score += Math.pow(2, i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		cogs = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				cogs[i][j] = s.charAt(j) - '0';
			}
		}
		
		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			simulate(n-1, d);
		}
		
		scoring();
		System.out.println(score);
	}

}
