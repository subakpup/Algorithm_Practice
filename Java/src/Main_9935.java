import java.io.*;

public class Main_9935 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String line = br.readLine();
		String bomb = br.readLine();
		int lineLen = line.length();
		int bombLen = bomb.length();
		
		for (int i = 0; i < lineLen; i++) {
			char c = line.charAt(i);
			sb.append(c);
			
			if (sb.length() >= bombLen) {
				boolean isBomb = true;
				
				for (int j = 0; j < bombLen; j++) {
					if (bomb.charAt(j) != sb.charAt(sb.length() - bombLen + j)) {
						isBomb = false;
						break;
					}
				}
				
				if (isBomb) {
					sb.delete(sb.length() - bombLen, sb.length());
				}
			}
		}
		
		if (sb.length() == 0) System.out.println("FRULA");
		else System.out.println(sb.toString());
	}

}
