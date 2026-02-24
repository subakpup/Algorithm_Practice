import java.io.*;
import java.util.*;

public class Main_2607 {
	static int n, cnt, answer;
	static int[] app;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		app = new int[26];
		String first = br.readLine();
		for (int i = 0; i < first.length(); i++) {
			int idx = first.charAt(i) - 'A';
			++app[idx];
		}
		
		
		for (int i = 0; i < n-1; i++) {
			int[] tmp = Arrays.copyOf(app, 26);
			cnt = 0;
			
			String word = br.readLine();
			for (int j = 0; j < word.length(); j++) {
				int idx = word.charAt(j) - 'A';
				if (tmp[idx] > 0) {
					++cnt;
					--tmp[idx];
				}
			}
			
			int fl = first.length();
			int wl = word.length();
			
			if (fl == wl && fl == cnt) ++answer;
			else if (fl == wl && fl-1 == cnt) ++answer;
			else if (fl-1 == wl && fl-1 == cnt) ++answer;
			else if (fl+1 == wl && fl == cnt) ++answer;
		}
		
		System.out.println(answer);
	}

}
