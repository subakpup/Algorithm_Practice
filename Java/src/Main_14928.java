import java.io.*;

public class Main_14928 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = br.readLine();
		long answer = 0;
		
		for (int i = 0; i < n.length(); i++) {
			answer = (answer * 10 + (n.charAt(i) - '0')) % 20000303;
		}
		
		System.out.println(answer);
	}

}
