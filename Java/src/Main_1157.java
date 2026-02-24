import java.io.*;

public class Main_1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int[] alpha = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
				++alpha[s.charAt(i) - 'a'];
			} else {
				++alpha[s.charAt(i) - 'A'];
			}
		}
		
		int max = -1;
		char c = '?';
		for (int i = 0; i < 26; i++) {
			if (alpha[i] > max) {
				max = alpha[i];
				c = (char) (i + 'A');
			} else if (alpha[i] == max) {
				c = '?';
			}
		}
		
		System.out.println(c);
	}

}
