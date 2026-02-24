import java.util.*;
import java.io.*;

public class Main_3109 {
    static int R, C, answer;
    static String[][] graph;
    static int[] dr = new int[] {-1, 0, 1};
    static int[] dc = new int[] {1, 1, 1};
    
    private static boolean isIn(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }
    
    private static boolean dfs(int r, int c) {
        graph[r][c] = "x";
        
        if (c == C - 1) {
            return true;
        }
        
        for (int i = 0; i < 3; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (isIn(nr, nc) && graph[nr][nc].equals(".")) {
                if (dfs(nr, nc)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        
        graph = new String[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = String.valueOf(line.charAt(j));
            }
        }
        
        answer = 0;
        
        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

}