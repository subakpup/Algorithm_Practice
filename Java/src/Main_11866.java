/*
 * Main_11866_요세푸스문제0_함지수
 * 
 * 메모리: 21488kb; 시간: 100ms
 * 
 * 요세푸스 문제는 다음과 같습니다.
 *  - 1번부터 N번까지 사람이 원을 이루며 앉아 있음
 *  - 순서대로 K번째 사람을 제거
 *  - 한 사람이 제거되면 남은 사람들로 원을 따라 이 과정 반복
 *  >> 원에서 사람들이 제거되는 순서를 (N,K)-요세푸스 순열이라고 함
 *  
 * # 구현할 내용
 *  1. N,K 입력
 *  2. 1부터 N까지의 사람이 존재하는 큐 구현
 *  3. K번째 사람 제거하는 로직
 *  4. 올바른 출력
 */

import java.io.*;
import java.util.*;

public class Main_11866 {

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 출력
		StringBuilder sb = new StringBuilder();
		
		// 큐
		LinkedList<Integer> queue = new LinkedList<>();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 1부터 N까지 사람 큐에 삽입
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		
		sb.append("<");
		
		// 큐에 모든 사람이 존재하지 않을 때까지 반복
		while (!queue.isEmpty()) {
			for (int i = 0; i < k - 1; i++) { // K - 1번 동안 앞에 있는 사람 뒤로 보내기
				queue.add(queue.removeFirst());
			}
			sb.append(queue.removeFirst()); // K번째 사람 추출
			
			if (!queue.isEmpty()) {
				sb.append(", ");
			}
		}
		
		sb.append(">");
		
		System.out.println(sb); // 결과 출력
		
	}

}
