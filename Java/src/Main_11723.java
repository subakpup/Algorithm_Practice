import java.io.*;
import java.util.*;

public class Main_11723 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> li = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			switch (cmd) {
			case "add":
				li.add(Integer.parseInt(st.nextToken()));
				break;
			case "remove":
				int tmp = Integer.parseInt(st.nextToken());
				li.remove(Integer.valueOf(tmp));
				break;
			case "check":
				tmp = Integer.parseInt(st.nextToken());
				if (li.contains(tmp)) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
			case "toggle":
				tmp = Integer.parseInt(st.nextToken());
				if (li.contains(tmp)) {
					li.remove(Integer.valueOf(tmp));
				} else {
					li.add(tmp);
				}
				break;
			case "all":
				li.clear();
				for (int idx = 1; idx <= 20; idx++) {
					li.add(idx);
				}
				break;
			case "empty":
				li.clear();
				break;
			}
		}
		System.out.println(sb.toString());
	}

}
