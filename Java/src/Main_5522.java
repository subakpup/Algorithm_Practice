import java.io.*;

public class Main_5522 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = 0;
		for (int i = 0; i < 5; i++) {
			answer += Integer.parseInt(br.readLine());
		}
		
		System.out.println(answer);
	}

}
