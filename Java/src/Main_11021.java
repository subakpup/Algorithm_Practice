import java.util.*;
import java.io.*;

public class Main_11021 {
	static StringBuilder sb = new StringBuilder();
	
 	public static void main(String[] args) throws IOException {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		int t = Integer.parseInt(br.readLine());
 		for (int i = 1; i <= t; i++) {
 			StringTokenizer st = new StringTokenizer(br.readLine());
 			int a = Integer.parseInt(st.nextToken());
 			int b = Integer.parseInt(st.nextToken());
 			sb.append("Case #").append(i).append(": ").append(a+b).append('\n');
 		}
 		
 		System.out.println(sb.toString());
	}

}
