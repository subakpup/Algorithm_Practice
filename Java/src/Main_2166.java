import java.util.*;
import java.io.*;

public class Main_2166 {
	static int n;
	static int[][] figure;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		figure = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			figure[i][0] = x;
			figure[i][1] = y;
		}
		
		double answer = 0;
		for (int i = 0; i < n; i++) {
			answer += (double) figure[i][0] * figure[(i+1) % n][1] - (double) figure[(i+1) % n][0] * figure[i][1];
		}
		
		System.out.printf("%.1f", Math.abs(answer) / 2);
	}

}
