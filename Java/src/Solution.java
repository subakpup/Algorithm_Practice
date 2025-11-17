import java.io.*;
import java.util.*;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] trees = new int[n];
			int maxHeight = 0;
			for (int i = 0; i < n; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, trees[i]);
			}
			
			int total = 0;
			int even = 0;
			for (int i = 0; i < n; i++) {
				total += maxHeight - trees[i];
				even += (maxHeight - trees[i]) / 2;
			}
			
			int answer = Integer.MAX_VALUE;
			
			for (int i = 0; i <= even; i++) {
				int cnt1 = total - i * 2;
				int cnt2 = i;
				answer = Math.min(answer, Math.max(cnt1 * 2 - 1, cnt2 * 2));
			}
			
			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		
		System.out.println(sb.toString());
	}
}
