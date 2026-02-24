import java.io.*;

public class Main_2720 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append(n / 25).append(' ');
			n %= 25;
			
			sb.append(n / 10).append(' ');
			n %= 10;
			
			sb.append(n / 5).append(' ');
			n %= 5;
			
			sb.append(n / 1).append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
