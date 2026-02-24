import java.io.*;

public class Main_10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alpha = new int[26];
		String s = br.readLine();
		int idx = 0;
		for (int i = 0; i < 26; i++) {
			alpha[i] = -1;
		}
		for (int i = 0; i < s.length(); i++) {
			if (alpha[s.charAt(i) - 'a'] == -1) {
				alpha[s.charAt(i) - 'a'] = idx;
			}
			idx++;
		}
		
		for (int n : alpha) {
			System.out.print(n + " ");
		}
	}

}
