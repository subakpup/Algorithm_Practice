import java.util.*;
import java.io.*;

public class Main_2751 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(nums);
		
		StringBuilder sb = new StringBuilder();
		for (int i : nums) sb.append(i).append('\n');
		System.out.println(sb.toString());
	}
}
