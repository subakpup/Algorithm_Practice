/*
 * Solution_2382 미생물 격리 (D4)
 * 
 * # 문제 정리
 *  - 정사각형 구역 안 K개 군집
 *  - 가로, 세로 모두 N인 정사각형 구역
 *  - 가장자리는 약품 처리
 *   1. 최초 각 미생물 군집 위치, 미생물 수, 이동 방향 주어짐
 *    └이동 방향은 (상, 하, 좌, 우)
 *   2. 군집들은 1시간 마다 다음 셀로 이동
 *   3. 군집이 이동 후 약품에 닿으면
 *    => 절반이 죽고, 이동 방향이 반대로 바뀜
 *   4. 이동 후, 두 개 이상 군집이 모일 경우
 *    => 군집이 합쳐짐. 이동 방향은 미생물 수가 더 많은 쪽
 *  - M 시간 후 미생물의 총합을 구하라
 *  
 * # 아이디어
 *  - 미생물 군집을 저장할 객체를 생성하자 ! (훨씬 편할 듯합니다)
 *  - 가장자리에 도달하면 나누고 방향 돌리기
 *  - 3차원 배열을 이용해 이동하는 곳의 좌표에 셀들의 총합, 가장 큰 군집의 번호, 해당 군집의 이동방향을 저장하자
 *  
 */
import java.util.*;
import java.io.*;

public class Solution_2382 {
    
    static class Group {
        int r, c, cnt, dir;

        public Group(int r, int c, int cnt, int dir) {
            super();
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.dir = dir;
        }
    }
        
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    
    static int n, m, k, answer;
    static List<Group> groups;
    
    // 상, 하, 좌, 우
    static final int[] dr = {0, -1, 1, 0, 0};
    static final int[] dc = {0, 0, 0, -1, 1};
    static final int[] rev = {0, 2, 1, 4, 3}; // 반대 방향 매핑
    
    
    private static void simulate() {
        for (int time = 0; time < m; time++) {
            
        	// 1. 해당 셀로 모인 미생물의 총합
        	// 2. 그중 "가장 큰 개수"
        	// 3. 이동 방향
            int[][][] next = new int[n][n][3];
            
            // 1) 이동 + 테두리 처리 + 셀에 누적 
            for (Group g : groups) {
                int nr = g.r + dr[g.dir];
                int nc = g.c + dc[g.dir];
                int ncnt = g.cnt;
                int ndir = g.dir;
                
                // 약품에 닿았을 경우: 절반/반전
                if (nr == 0 || nr == n-1 || nc == 0 || nc == n-1) {
                    ncnt /= 2;
                    if (ncnt == 0) continue;
                    ndir = rev[ndir];
                }
                
                next[nr][nc][0] += ncnt; // 해당 좌표에 도달한 미생물 개수
                if (ncnt > next[nr][nc][1]) { // 가장 큰 개수 보다 크다 = 여러 개가 도달했다 !
                	next[nr][nc][1] = ncnt; // 큰 군집 개수 할당
                	next[nr][nc][2] = ndir; // 방향도 큰 군집으로 설정
                }
            }
            
            // 다음 시간대의 모습으로 재구성
            List<Group> move = new ArrayList<>();
            for (int r = 0; r < n; r++) {
            	for (int c = 0; c < n; c++) {
            		int sum = next[r][c][0];
            		if (sum > 0) {
            			int dir = next[r][c][2];
            			move.add(new Group(r, c, sum, dir));
            		}
            	}
            }
            
            groups = move;
            
        }
        
        // 남은 미생물 총합
        answer = 0;
        for (Group g : groups) {
        	answer += g.cnt;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 격자 크기
            m = Integer.parseInt(st.nextToken()); // 시간
            k = Integer.parseInt(st.nextToken()); // 군집 수
            
            groups = new ArrayList<>();
            for (int idx = 1; idx <= k; idx++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                groups.add(new Group(r, c, cnt, dir));
            }
            
            simulate();
            
            sb.append("#" + tc + " " + answer + "\n");
        }
        System.out.println(sb.toString());
    }

}