import java.util.*;
import java.io.*;

public class Main_1764 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static Set<String> names;
	static List<String> answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		names = new HashSet<>();
		for (int i = 0; i < n; i++) {
			names.add(br.readLine());
		}
		
		answer = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			String name = br.readLine();
			if (names.contains(name)) answer.add(name);
		}
		
		Collections.sort(answer);
		sb.append(answer.size() + "\n");
		for (String n : answer) sb.append(n + "\n");
		System.out.println(sb.toString());
	}

}
