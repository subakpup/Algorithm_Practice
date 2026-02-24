import java.io.*;

public class Main_2588 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		String b = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		for (int i = b.length() - 1; i >= 0; i--) {
			sb.append(a * (b.charAt(i) - '0')).append('\n');
		}
		sb.append(a * Integer.parseInt(b));
		
		System.out.println(sb.toString());
	}

}
