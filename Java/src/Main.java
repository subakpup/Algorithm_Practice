import java.io.*;
import java.util.*;

public class Main {
    static int N, M, color;
    static int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 상하좌우
    static int[][] map;
    static boolean[][] visited1;
    static int[][] bridge;
    static int min = 100;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited1 = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1. 섬 구하기
        color = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited1[i][j]) {
                    visited1[i][j] = true;
                    dfs1(i, j, ++color);
                }
            }
        }
        // 2. 섬 사이 거리 구하기
        bridge = new int[color+1][color+1];
        for (int i = 1; i <= color; i++) {
            for (int j = 1; j <= color; j++) {
                bridge[i][j] = 10;
            }
        }
        calBridge();

        // 모든 경로 중 가장 가까운 거리 구하기
        boolean[][] visited2 = new boolean[color+1][color+1];
        dfs2(1, visited2, 0);
        if (min == 100) System.out.println(-1);
        else System.out.println(min);
        br.close();
    }
    // 섬 파악하기
    static void dfs1(int i, int j, int color) {
        map[i][j] = color;
        for (int k = 0; k < 4; k++) {
            int dx = i + d[k][0];
            int dy = j + d[k][1];
            if (0<=dx && dx<N && 0<=dy && dy<M // 범위체킹
                && !visited1[dx][dy] && map[dx][dy] == 1) { // 방문체킹, 연결체킹
                visited1[dx][dy] = true;
                dfs1(dx, dy, color);
            }
        }
    }
    // 가장 가까운 거리 조합 구하기
    static void dfs2(int node, boolean[][] visited2, int sum) {
        if (node == color) {
            min = Math.min(sum, min);
            return;
        }
        for (int i = 1; i <= color; i++) {
            if (bridge[i][node] != 10 && !visited2[node][i]) {
                boolean[][] vc = new boolean[color+1][color+1];
                for (int j = 0; j < color + 1; j++) vc[j] = visited2[j].clone();
                vc[i][node] = true;
                dfs2(node+1, vc, sum + bridge[i][node]);
            }
        }
    }
    static void calBridge() {
        // 섬과 섬 사이의 최소 거리 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] >= 1) { // 섬이라면
                    int c1 = map[i][j]; // c1 은 출발섬
                    // 그 섬을 기준으로 상 하 좌 우 탐색
                    int len = 0;
                    for (int k = i-1; k >= 0; k--) {
                        int c2 = map[k][j]; // c2 는 도착섬
                        if (c2 == 0) len++; // 바다라면 다리 길이 +1
                        else { // 섬일때
                            if (c1 != c2 && len >= 2) {
                                bridge[c1][c2] = Math.min(len, bridge[c1][c2]);
                                bridge[c2][c1] = Math.min(len, bridge[c2][c1]);
                            }
                            else break;
                        }
                    }
                    len = 0;
                    for (int k = i+1; k < N; k++) {
                        int c2 = map[k][j]; // c2 는 도착섬
                        if (c2 == 0) len++; // 바다라면 다리 길이 +1
                        else {
                            if (c1 != c2 && len >= 2) {
                                bridge[c1][c2] = Math.min(len, bridge[c1][c2]);
                                bridge[c2][c1] = Math.min(len, bridge[c2][c1]);
                            }
                            else break;
                        }
                    }
                    len = 0;
                    for (int k = j-1; k >= 0; k--) {
                        int c2 = map[i][k]; // c2 는 도착섬
                        if (c2 == 0) len++; // 바다라면 다리 길이 +1
                        else {
                            if (c1 != c2 && len >= 2) {
                                bridge[c1][c2] = Math.min(len, bridge[c1][c2]);
                                bridge[c2][c1] = Math.min(len, bridge[c2][c1]);
                            }
                            else break;
                        }
                    }
                    len = 0;
                    for (int k = j+1; k < M; k++) {
                        int c2 = map[i][k]; // c2 는 도착섬
                        if (c2 == 0) len++; // 바다라면 다리 길이 +1
                        else {
                            if (c1 != c2 && len >= 2) {
                                bridge[c1][c2] = Math.min(len, bridge[c1][c2]);
                                bridge[c2][c1] = Math.min(len, bridge[c2][c1]);
                            }
                            else break;
                        }
                    }
                }
            }
        }
    }
}