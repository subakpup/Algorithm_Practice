import java.io.*;

public class Main_10988 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		StringBuilder sb = new StringBuilder(s).reverse();
		
		System.out.println(s.equals(sb.toString()) ? 1 : 0);
	}

}
