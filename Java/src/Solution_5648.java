/*
 * Solution_5648 원자 소멸 시뮬레이션
 * 
 * # 문제 정리
 *  - 원자들은 2차원 평면에서 이동하며 
 *  - 두 개 이상의 원자가 충돌 할 경우 충돌한 원자들은 각자 보유한 에너지를 모두 방출하고 소멸
 *  - 원자는 각자 고유의 움직이는 방향을 보유
 *  - 원자들의 이동속도는 동일
 *  - 모든 원자들은 최초 위치에서 동시에 이동
 *  - 두 개 이상의 원자가 충돌한 경우 에너지를 방출하고 소멸
 *  - 0.5초마다 충돌할 수 있음(원래 사이즈의 2배 만큼 선언해야 할 듯)
 *  
 */
import java.util.*;
import java.io.*;

public class Solution_5648 {
	
	static class Element {
		int r, c, d, k;
		
		Element (int r, int c, int d, int k) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.k = k;
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static int n;

	static final int[] dr = {0, 0, -1, 1};
	static final int[] dc = {1, -1, 0, 0};
	
	private static long simulate(List<Element> elements) {
		long total = 0L;
		
		while (elements.size() >= 2) {
			Set<Long> loc = new HashSet<>(elements.size()); // 이동 위치 기록
			Set<Long> hit = new HashSet<>(elements.size()); // 충돌 발생 위치
			List<Element> nxt = new ArrayList<>(elements.size()); // 이동 후 상태
			
			for (Element e : elements) {
				int nr = e.r + dr[e.d];
				int nc = e.c + dc[e.d];
				
				if (nr < 0 || nr > 4000 || nc < 0 || nc > 4000) continue;
				
				long key = pack(nr, nc); // 해당 좌표를 키로 저장
				if (!loc.add(key)) { // 이미 존재하면 이번 턴에 충돌
					hit.add(key);
				}
				nxt.add(new Element(nr, nc, e.d, e.k));
			}
			
			elements.clear();
			
			for (Element e : nxt) {
				Long key = pack(e.r, e.c);
				if (hit.contains(key)) { // 충돌할 원소라면
					total += e.k; // 충돌 -> 에너지 합산
				} else {
					elements.add(e); // 생존 원자만 다음 틱으로
				}
			}
		}
		
		return total;
	}
	
	private static long pack(int r, int c) {
		return (long) r * 10000L + (long) c;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			List<Element> elements = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				
				// 음수 방지, 0.5초 보정을 위해 좌표 2배 확장
				elements.add(new Element((r + 1000) * 2, (c + 1000) * 2, d, k));
			}
			
			sb.append("#" + tc + " " + simulate(elements) + "\n");
		}
		System.out.println(sb.toString());
	}

}
