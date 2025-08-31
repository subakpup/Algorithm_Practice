
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	private static void quad(int x, int y, int len) {
		int point = map[x][y];
		boolean flag = true;
		
		for (int r = x; r < x + len; r++) {
			for (int c = y; c < y + len; c++) {
				if (map[r][c] != point) {
					flag = false;
				}
			}
		}
		
		if (!flag) {
			int half = len / 2;
			sb.append("(");
			quad(x, y, half);
			quad(x, y + half, half);
			quad(x + half, y, half);
			quad(x + half, y + half, half);
			sb.append(")");
			return;
		}
		
		sb.append(point);
		
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	map = new int[n][n];
    	for (int i = 0; i < n; i++) {
    		String line = br.readLine();
    		for (int j = 0; j < n; j++) {
    			map[i][j] = line.charAt(j) - '0';
    		}
    	}
    	
    	quad(0, 0, n);
    	System.out.println(sb.toString());
    	
    }
}