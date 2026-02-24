import java.io.*;

public class Main_2903 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = (int) Math.pow(Math.pow(2, n) + 1, 2);
		
		System.out.println(answer);
	}

}
