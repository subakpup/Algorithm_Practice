import java.util.*;
import java.io.*;

public class Main_4153 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] num = new int[3];
			for (int i = 0; i < 3; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			if (num[0] == 0 && num[0] == num[1] && num[1] == num[2]) break;
			
			Arrays.sort(num);
			
			boolean chk = Math.pow(num[0], 2) + Math.pow(num[1], 2) == Math.pow(num[2], 2);
			if (chk) sb.append("right\n");
			else sb.append("wrong\n");
		}
		System.out.println(sb);
	}

}
