import java.io.*;

public class Main_1316 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int answer = 0;
		
		Loop:
		for (int i = 0; i < n; i++) {
			boolean[] isUsed = new boolean[26];
			String s = br.readLine();
			isUsed[s.charAt(0) - 'a'] = true;
			
			for (int j = 1; j < s.length(); j++) {
				if (s.charAt(j - 1) == s.charAt(j)) continue;
				else if (isUsed[s.charAt(j) - 'a']) continue Loop;
				isUsed[s.charAt(j) - 'a'] = true;
			}
			
			++answer;
		}
		
		System.out.println(answer);
	}

}
