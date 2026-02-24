
import java.util.*;
import java.io.*;

public class Main_2798 {
	static int n, m, answer;
	static int[] cards;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		cards = new int[n];
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = 0;
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					if (cards[i] + cards[j] + cards[k] > m) continue;
					answer = Math.max(answer, cards[i] + cards[j] + cards[k]);
				}
			}
		}
		System.out.println(answer);
	}
}
