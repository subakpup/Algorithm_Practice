import java.util.*;
import java.io.*;

public class Main_10250 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			int answer = 101;
			while (n - h > 0) {
				answer += 1;
				n -= h;
			}
			answer += (n-1) * 100;
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}

}
