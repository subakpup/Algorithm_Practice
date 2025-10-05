import java.io.*;

public class Main_2562 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int idx = 0;
		for (int i = 1; i <= 9; i++) {
			int a = Integer.parseInt(br.readLine());
			if (answer < a) {
				answer = a;
				idx = i;
			}
		}
		System.out.println(answer + "\n" + idx);
	}

}
