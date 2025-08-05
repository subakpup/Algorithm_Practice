import java.util.*;
import java.io.*;

public class Main_1991 {
	static int n;
	static Map<String, String[]> tree = new HashMap<>();
	
	// 전위 순회
	public static String preorder(String node) {
		// 자식 노드가 없을 경우 출력할 수 없으니, 공백으로 리턴
		if (node.equals(".")) {
			return "";
		}
		
		// 왼쪽 자식 노드, 오른쪽 자식 노드
		String left = tree.get(node)[0];
		String right = tree.get(node)[1];
		
		// (루트) (왼쪽 자식) (오른쪽 자식)
		return node + preorder(left) + preorder(right);
	}
	
	// 중위 순회
	public static String inorder(String node) {
		if (node.equals(".")) {
			return "";
		}
		
		String left = tree.get(node)[0];
		String right = tree.get(node)[1];
		
		// (왼쪽 자식) (루트) (오른쪽 자식)
		return inorder(left) + node + inorder(right);
	}

	// 후위 순회
	public static String postorder(String node) {
		if (node.equals(".")) {
			return "";
		}
		
		String left = tree.get(node)[0];
		String right = tree.get(node)[1];
		
		// (왼쪽 자식) (오른쪽 자식) (루트)
		return postorder(left) + postorder(right) + node;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String root = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			tree.put(root, new String[] {left, right});
		}
		
		// 루트 노드인 A부터 시작
		System.out.println(preorder("A"));
		System.out.println(inorder("A"));
		System.out.println(postorder("A"));
	}

}
