import java.io.*;

public class Main_8393 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int answer = 0;
		for (int i = 1; i <= n; i++) answer += i;
		System.out.println(answer);
	}

}
