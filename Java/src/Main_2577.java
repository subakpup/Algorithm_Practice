import java.io.*;

public class Main_2577 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int n = a * b * c;
		
		int[] cnt = new int[10];
		String s = String.valueOf(n);
		for (int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i) - '0']++;
		}
		
		for (int r : cnt) {
			System.out.println(r);
		}
	}

}
