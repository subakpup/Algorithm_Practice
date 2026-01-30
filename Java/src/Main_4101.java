import java.io.*;
import java.util.*;

public class Main_4101 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if (n == 0 && m == 0) break;
			
			sb.append(n > m ? "Yes" : "No").append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
