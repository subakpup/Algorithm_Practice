import java.io.*;

public class Main_10798 {
	static StringBuilder sb = new StringBuilder();
	static char[][] ch = new char[5][15];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 5; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < s.length(); j++) {
				ch[i][j] = s.charAt(j);
			}
		}
		
		for (int j = 0; j < 15; j++) {
			for (int i = 0; i < 5; i++) {
				if (ch[i][j] == '\0') continue;
				sb.append(ch[i][j]);
			}
		}
		
		System.out.println(sb.toString());
	}

}
