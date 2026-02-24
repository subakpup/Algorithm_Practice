import java.util.*;
import java.io.*;

public class Main_2493 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] tower = new int[n+1];
		for (int i = 1; i <= n; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] answer = new int[n+1];
		Stack<int[]> stack = new Stack<>();
		for (int i = 1; i <= n; i++) {
			while (!stack.isEmpty()) {
				if (tower[i] > stack.peek()[0]) {
					stack.pop();
				} else {
					answer[i] = stack.peek()[1];
					break;
				}
			}
			
			stack.add(new int[] {tower[i], i}); // 높이, 위치
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.print(answer[i] + " ");
		}
	}

}
