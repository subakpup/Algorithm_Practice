import java.util.*;
import java.io.*;

public class Main_1620 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static Map<Integer, String> names = new HashMap<>();
	static Map<String, Integer> numbers = new HashMap<>();
	
	private static boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e){
			return false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for (int num = 1; num <= n; num++) {
			String name = br.readLine();
			names.put(num, name);
			numbers.put(name, num);
		}
		
		for (int j = 0; j < m; j++) {
			String cmd = br.readLine();
			
			if (isNumber(cmd)) {
				sb.append(names.get(Integer.parseInt(cmd))).append("\n");
			} else {
				sb.append(numbers.get(cmd)).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
