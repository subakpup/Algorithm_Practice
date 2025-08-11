import java.io.*;
import java.util.*;

public class Main_10818 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int mx = -1000000;
		int mn = 1000000;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num > mx) mx = num;
			if (num < mn) mn = num;
		}
		System.out.println(mn + " " + mx);
	}

}
