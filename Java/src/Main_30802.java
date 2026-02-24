import java.util.*;
import java.io.*;

public class Main_30802 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] size = new int[6];
		for (int i = 0; i < 6; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		for (int i = 0; i < 6; i++) {
			answer += size[i] / t;
			answer = size[i] % t > 0 ? answer + 1 : answer;
		}
		
		int bundle = n / p;
		int piece = n % p;
		
		System.out.println(answer + "\n" + bundle + " " + piece);
	}

}
