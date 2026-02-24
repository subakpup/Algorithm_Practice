import java.util.*;
import java.io.*;

public class Main_11022 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append("Case #").append(i).append(": ").append(a).append(" + ").append(b).append(" = ").append(a+b).append('\n');
		}
		
		System.out.println(sb.toString());

	}

}
