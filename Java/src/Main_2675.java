import java.util.*;
import java.io.*;

public class Main_2675 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < n; j++) {
					sb.append(s.charAt(i));
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
