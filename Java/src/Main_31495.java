import java.io.*;

public class Main_31495 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		StringBuilder sb = new StringBuilder(s);
		
		if (sb.charAt(0) == '"' && sb.charAt(sb.length()-1) == '"' && sb.length() < 3) {
			sb = new StringBuilder("CE");
		} else if (sb.charAt(0) == '"' && sb.charAt(sb.length()-1) == '"') {
			sb.deleteCharAt(0);
			sb.deleteCharAt(sb.length()-1);
		} else {
			sb = new StringBuilder("CE");
		}
		
		System.out.println(sb.toString());
	}

}
