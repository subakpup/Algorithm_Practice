import java.io.*;

public class Main_2292 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int box = 1;
		int cnt = 1;
		
		while (n > box) {
			box += 6 * cnt;
			cnt++;
		}
		
		System.out.println(cnt);
	}

}
