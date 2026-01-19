import java.util.*;
import java.io.*;

public class Main_2745 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String n = st.nextToken();
		int b = Integer.parseInt(st.nextToken());
		
		int answer = Integer.parseInt(n, b);
		System.out.println(answer);
	}

}
