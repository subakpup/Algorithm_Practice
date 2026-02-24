import java.io.*;

public class Main_2941 {
	static String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		for (String c : croatia) {
			s = s.replace(c, "*");
		}
		
		System.out.println(s.length());
	}

}
