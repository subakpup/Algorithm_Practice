import java.util.*;
import java.io.*;

public class Solution {
	static int n, m;
	static int[][] arr, pre;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			arr = new int[n+1][n+1];
			pre = new int[n+1][n+1];
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					pre[i][j] = arr[i][j] + pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1];
				}
			}
			
			int answer = 0;
			for (int i = m; i <= n; i++) {
				for (int j = m; j <= n; j++) {
					int tmp = pre[i][j] - pre[i-m][j] - pre[i][j-m] + pre[i-m][j-m];
					answer = Math.max(answer, tmp);
				}
			}
			
			sb.append("#" + tc + " " + answer + "\n");
			
		}
		System.out.println(sb);
	}

}
