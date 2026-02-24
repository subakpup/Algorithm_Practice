import java.io.*;

public class Main_11720 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int answer = 0;
		for (int i = 0; i < n; i++) {
			answer += s.charAt(i) - '0';
		}
		System.out.println(answer);
	}

}
