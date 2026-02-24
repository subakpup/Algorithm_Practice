import java.util.*;
import java.io.*;

public class Main_1244 {
	static int n,s,idx;
	static int[] arr;
	static String gender;
	
	// 남학생
	public static void boy(int idx) {
		for (int i = idx; i < n; i += idx + 1) { // 배수만큼 증가
			arr[i] = 1 - arr[i]; // 상태 전환
		}
	}
	
	// 여학생
	public static void girl(int idx) {
		// 오른쪽 왼쪽 인덱스
		int left = idx - 1;
		int right = idx + 1;
		
		// 입력받은 인덱스 값 먼저 전환
		arr[idx] = 1 - arr[idx];
		
		// 범위 내 && 좌우대칭
		while (left >= 0 && right < n && arr[left] == arr[right]) {
			arr[left] = 1 - arr[left];
			arr[right] = 1 - arr[right];
			left--;
			right++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		// 스위치 배열
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 입력받은 학생의 수, 커맨드
		s = Integer.parseInt(br.readLine());
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			gender = st.nextToken();
			idx = Integer.parseInt(st.nextToken()) - 1;
			if (gender.equals("1")) {
				boy(idx);
			} else {
				girl(idx);
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(arr[i]).append(" ");
			if ((i+1) % 20 == 0) sb.append("\n");
		}
		System.out.println(sb);
		
	}

}
