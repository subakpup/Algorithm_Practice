import java.io.*;
import java.util.*;

public class Main_2492 {
	static int n, m, t, k, x, y, answer;
	static int[] row, col;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		row = new int[t];
		col = new int[t];
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			row[i] = Integer.parseInt(st.nextToken());
			col[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = 0;
		x = 0;
		y = 0;
		
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < t; j++) {
				int r = row[i];
				int c = col[j];
				
				if (r + k >= n) r = n-k;
				if (c + k >= m) c = m-k;
				
				int tmp = 0;
				for (int idx = 0; idx < t; idx++) {
					if (r > row[idx] || row[idx] > r+k || c > col[idx] || col[idx] > c+k) continue;
					tmp++;
					
				}
				if (answer < tmp) {
					answer = tmp;
					x = r;
					y = c + k;
				}
			}
		}
		
		System.out.println(x + " " + y + "\n" + answer);
		
	}

}
