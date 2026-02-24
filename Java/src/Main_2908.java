import java.util.*;
import java.io.*;

public class Main_2908 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder s1 = new StringBuilder(st.nextToken()).reverse();
		StringBuilder s2 = new StringBuilder(st.nextToken()).reverse();
		
		int n1 = Integer.parseInt(s1.toString());
		int n2 = Integer.parseInt(s2.toString());
		
		System.out.println(n1 > n2 ? n1 : n2);
	}

}
