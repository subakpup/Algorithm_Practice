import java.util.*;
import java.io.*;

public class Main_2566 {
	static int r, c;
	static int max = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 1; i <= 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n > max) {
					max = n;
					r = i; c = j;
				}
			}
		}
		
		System.out.println(max + "\n" + r + " " + c);
	}

}
