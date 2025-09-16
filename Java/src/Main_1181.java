import java.util.*;
import java.io.*;

public class Main_1181 {
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		Set<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		
		List<String> list = new ArrayList<>(set);
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				if (a.length() == b.length()) {
					return a.compareTo(b);
				} else {
					return a.length() - b.length();
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (String s : list) sb.append(s).append('\n');
		System.out.println(sb.toString());
	}
}
