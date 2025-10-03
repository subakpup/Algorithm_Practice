import java.util.*;
import java.io.*;

public class Main_2309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] heights = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			heights[i] = Integer.parseInt(br.readLine());
			sum += heights[i];
		}
		
		search:
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - heights[i] - heights[j] == 100) {
					heights[i] = 0; heights[j] = 0;
					break search;
				}
			}
		}
		
		Arrays.sort(heights);
		for (int i = 2; i < 9; i++) {
			System.out.println(heights[i]);
		}
	}

}
