import java.io.*;
import java.util.*;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static final int INF = (int) 1e9;

	static int T, N, P;
	static List<Pos> people;
	static Stair[] stairs;
	static int[][] dist; // i번 사람이 0/1번 계단까지의 맨해튼 거리

	static List<Integer> arrivals0; // 0번 계단 도착시각들 (dist+1)
	static List<Integer> arrivals1; // 1번 계단 도착시각들 (dist+1)
	static int answer;

	static class Pos {
		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Stair {
		int r, c, len;

		Stair(int r, int c, int len) {
			this.r = r;
			this.c = c;
			this.len = len;
		}
	}

	/**
	 * 재귀 DFS로 i번째 사람의 계단 선택을 결정. - 리스트에 도착시각(dist+1)을 push/pop 하며 진행.
	 */
	private static void dfsAssign(int i) {
		// 모든 사람 배정 완료 -> 두 계단 시뮬레이션 후 정답 갱신
		if (i == P) {
			int t0 = simulateStair(arrivals0, stairs[0].len);
			int t1 = simulateStair(arrivals1, stairs[1].len);
			int total = Math.max(t0, t1);
			if (total < answer) answer = total;
			return;
		}

		// 0번 계단 배정
		arrivals0.add(dist[i][0] + 1); // 계단 입구 도착 직후 1분(발 올리기) 포함
		dfsAssign(i + 1);
		arrivals0.remove(arrivals0.size() - 1);

		// 1번 계단 배정
		arrivals1.add(dist[i][1] + 1);
		dfsAssign(i + 1);
		arrivals1.remove(arrivals1.size() - 1);
	}

	/**
	 * 계단 하나에 대한 시뮬레이션: - arrivals: 각 사람이 '계단 진입 가능'해지는 시각(dist+1로 정의) - L: 계단
	 * 길이(내려가는 데 L분) 규칙: - 동시 3명까지 계단 이용 가능 - 자리가 없으면 가장 빨리 끝나는 시각부터 시작 - 끝시각 = 시작시각
	 * + L 반환: - 이 계단을 선택한 모든 사람이 내려가 '끝나는 마지막 시각'
	 */
	private static int simulateStair(List<Integer> arrivals, int L) {
		if (arrivals.isEmpty())
			return 0;

		List<Integer> a = new ArrayList<>(arrivals);
		Collections.sort(a);

		// 현재 계단을 내려가고 있는 사람들의 '끝시각'을 보관
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int lastFinish = 0;

		for (int arrival : a) {
			// arrival 시점까지 이미 끝난 사람들 제거
			while (!pq.isEmpty() && pq.peek() <= arrival) {
				pq.poll();
			}

			int start;
			if (pq.size() < 3) {
				// 자리가 있으면 도착 즉시 시작
				start = arrival;
			} else {
				// 자리가 없으면 가장 빨리 끝나는 시각부터 시작
				int earliestFinish = pq.poll();
				start = earliestFinish;
			}

			int finish = start + L;
			pq.offer(finish);
			if (finish > lastFinish) lastFinish = finish;
		}

		return lastFinish;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			people = new ArrayList<>();
			stairs = new Stair[2];

			int stairIdx = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int v = Integer.parseInt(st.nextToken());
					if (v == 1) {
						people.add(new Pos(i, j));
					} else if (v > 1) {
						stairs[stairIdx++] = new Stair(i, j, v);
					}
				}
			}

			P = people.size();
			dist = new int[P][2];
			for (int i = 0; i < P; i++) {
				Pos p = people.get(i);
				dist[i][0] = Math.abs(p.r - stairs[0].r) + Math.abs(p.c - stairs[0].c);
				dist[i][1] = Math.abs(p.r - stairs[1].r) + Math.abs(p.c - stairs[1].c);
			}

			arrivals0 = new ArrayList<>();
			arrivals1 = new ArrayList<>();
			answer = INF;

			dfsAssign(0); // i번째 사람부터 배정

			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}

		System.out.print(sb.toString());
	}
}
