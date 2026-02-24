import java.util.*;
import java.io.*;

public class Main_2920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[8];
		for (int i = 0; i < 8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		String answer = "";
		for (int i = 0; i < 7; i++) {
			if (arr[i] == arr[i+1] - 1) answer = "ascending";
			else if (arr[i] == arr[i+1] + 1) answer = "descending";
			else {
				answer = "mixed"; 
				break;
				}
		}
		System.out.println(answer);
	}

}
