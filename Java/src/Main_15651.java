import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static List<Integer> arr = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void dfs() {
		if (arr.size() == m) {
			for (int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			arr.add(i);
			dfs();
			arr.remove(arr.size()-1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dfs();
		System.out.println(sb.toString());
	}

}

/*
 * 실패 코드입니다.
 * 실행해 보시면 아시겠지만, n과m을 최댓값으로 설정하고 실행했을 때
 * 굉장히 오래 걸립니다.
 */
//import java.util.*;
//import java.io.*;
//
//public class Main {
//	static int n, m;
//	static List<Integer> arr = new ArrayList<>();
//
//	public static void dfs() {
//		if (arr.size() == m) {
//			for (int num : arr) {
//				System.out.print(num + " ");
//			}
//			System.out.println();
//			return;
//		}
//
//		for (int i = 1; i < n + 1; i++) {
//			arr.add(i);
//			dfs();
//			arr.remove(arr.size() - 1);
//		}
//	}
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		n = Integer.parseInt(st.nextToken());
//		m = Integer.parseInt(st.nextToken());
//		dfs();
//	}
//
//}

