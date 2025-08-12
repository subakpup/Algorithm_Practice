import java.util.*;
import java.io.*;

public class Main_8958 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int answer = 0;
			int tmp = 1;
			String n = br.readLine();
			for (int i = 0; i < n.length(); i++) {
				if (n.charAt(i) == 'O') answer += tmp++;
				else tmp = 1;
			}
			System.out.println(answer);
		}

	}

}
