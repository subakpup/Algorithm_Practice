import java.util.*;
import java.io.*;

public class Main_1759 {
	static StringBuilder sb = new StringBuilder();
	static int l, c;
	static String[] arr, result;
	static boolean[] visited;
	
	static final String vow = "aeiou";
	
	private static void dfs(int depth, int start) {
		if (depth == l) {
			if (isValid()) {
				for (String s : result) {
					sb.append(s);
				}
				sb.append('\n');
			}
			return;
		}
		
		for (int i = start; i < c; i++) {
			result[depth] = arr[i];
			dfs(depth + 1, i + 1);
		}
	}
	
	private static boolean isValid() {
		int cnt = 0;
		for (String s : result) {
			if (vow.contains(s)) {
				cnt++;
			}
		}
		
		if (cnt == 0 || l - cnt < 2) return false;
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new String[c];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			arr[i] = st.nextToken();
		}
		
		Arrays.sort(arr);
		
		result = new String[l];
		dfs(0, 0);
		
		System.out.println(sb.toString());
	}
}
