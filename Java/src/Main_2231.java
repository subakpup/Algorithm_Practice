import java.io.*;

public class Main_2231 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i = 1; i < n; i++) {
			int tmp = 0;
			int num = i;
			
			while (num != 0) {
				tmp += num % 10;
				num /= 10;
			}
			
			if (tmp + i == n) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}

}
