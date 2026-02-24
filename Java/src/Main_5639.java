import java.util.*;
import java.io.*;

public class Main_5639 {
	static StringBuilder sb = new StringBuilder();
	static List<Integer> graph = new ArrayList<>();
	
	private static void solve(int start, int end) {
		if (start > end) return;
		
		int root = graph.get(start);
		int child = start + 1;
		
		while (child <= end && graph.get(child) < root) {
			++child;
		}
		
		solve(start + 1, child - 1);
		solve(child, end);
		sb.append(root).append('\n');
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			try {
				graph.add(Integer.parseInt(br.readLine()));
			} catch (Exception e) {
				break;
			}
		}
		
		solve(0, graph.size() - 1);
		System.out.println(sb.toString());
	}

}
