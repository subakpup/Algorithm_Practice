import java.util.*;
import java.io.*;

public class Main_3003 {
	static StringBuilder sb = new StringBuilder();
	static int[] chess = { 1, 1, 2, 2, 2, 8 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 6; i++) {
			int n = Integer.parseInt(st.nextToken());
			sb.append(chess[i] - n).append(' ');
		}
		
		System.out.println(sb.toString());
	}

}
