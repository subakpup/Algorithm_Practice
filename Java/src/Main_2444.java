import java.io.*;

public class Main_2444 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n - i; j++) sb.append(' ');
			for (int j = 0; j < 2 * i - 1; j++) sb.append('*');
			sb.append('\n');
		}
		
		for (int i = n - 1; i >= 1; i--) {
			for (int j = 0; j < n - i; j++) sb.append(' ');
			for (int j = 0; j < 2 * i - 1; j++) sb.append('*');
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
