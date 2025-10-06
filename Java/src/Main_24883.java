import java.io.*;

public class Main_24883 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		String answer;
		if (s.equals("N") || s.equals("n")) {
			answer = "Naver D2";
		} else {
			answer = "Naver Whale";
		}
		
		System.out.println(answer);
	}

}
