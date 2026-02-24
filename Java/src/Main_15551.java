import java.io.*;

public class Main_15551 {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		String s1 = "";
		String s2 = "";
		
		for (int i = 0; i < n-2; i++) {
			s1 += "a";
			s2 += "a";
		}
		
		s1 += "Aa";
		s2 += "BB";
		
		System.out.println(s1 + "\n" + s2);
		
	}

}
