/*
 * Main_18258_큐2
 * 메모리: 399116 KB, 시간: 1368 ms
 * 
 * 정수를 저장하는 큐를 구현
 * - push X: 정수 X를 큐에 넣는 연산이다.
 * - pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * - size: 큐에 들어있는 정수의 개수를 출력한다.
 * - empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 * - front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * - back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * 
 * Queue를 LinkedList로 구현하면 쉽게 구현할 수 있을 거 같아 LinkedList 사용
 * 출력은 모든 입력을 받은 후 한 번에 출력하기 위해 StringBuilder 사용
 * 모든 명령을 switch문으로 선언하여 수행
 */

import java.io.*;
import java.util.*;

public class Main_18258 {
	public static void main(String[] args) throws IOException {
		// 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// Queue 구현
		LinkedList<Integer> queue = new LinkedList<>();
		
		// 반복할 횟수
		int N = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < N; t++) {
			String[] cmd = br.readLine().split(" "); 				// 입력 받는 명령(공백을 기준으로 나누어 줌)
			
			switch (cmd[0]) { 										// push를 포함한 모든 명령들이 첫 번째에 위치하므로	
			case "push":
					int val = Integer.parseInt(cmd[1]); 			// 삽입할 값
					queue.add(val);
					break;
				case "pop":
					if (queue.isEmpty()) { 							// 비어있다면 -1 출력
						sb.append(-1).append("\n");
					} else { 										// 아니라면 첫 번째값 pop
						sb.append(queue.removeFirst()).append("\n");
					}
					break;
				case "size":
					sb.append(queue.size()).append("\n"); 			// size 출력
					break;
				case "empty":
					if (queue.isEmpty()) { 							// 비어있다면 1
						sb.append(1).append("\n");
					} else { 										// 아니라면 0 출력
						sb.append(0).append("\n");
					}
					break;
				case "front":
					if (queue.isEmpty()) {							// 비어있다면 -1
						sb.append(-1).append("\n");
					} else {										// 아니라면 0번 인덱스 값 출력
						sb.append(queue.peek()).append("\n");
					}
					break;
				case "back":
						if (queue.isEmpty()) {						// 비어있다
						sb.append(-1).append("\n");
					} else {										// 아니라면 -1번 인덱스 값 출력
						sb.append(queue.peekLast()).append("\n");
					}
					break;
			}
		}
		
		System.out.println(sb);
	}

}
