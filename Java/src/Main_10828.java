import java.util.*;
import java.io.*;

public class Main_10828 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> arr = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			if (cmd.equals("push")) {
				int v = Integer.parseInt(st.nextToken());
				arr.add(v);
			} else if (cmd.equals("pop")) {
				if (arr.isEmpty()) sb.append(-1);
				else {
					sb.append(arr.get(arr.size() - 1));
					arr.remove(arr.size() - 1);
				}
				sb.append('\n');
			} else if (cmd.equals("size")) {
				sb.append(arr.size()).append('\n');
			} else if (cmd.equals("empty")) {
				if (arr.isEmpty()) sb.append(1);
				else sb.append(0);
				sb.append('\n');
			} else if (cmd.equals("top")) {
				if (arr.isEmpty()) sb.append(-1);
				else sb.append(arr.get(arr.size() - 1));
				sb.append('\n');
			}
		}
		
		System.out.println(sb.toString());
	}
}
