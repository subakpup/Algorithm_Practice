import java.util.*;
import java.io.*;

public class Main_17144 {
    static int R, C, T, cleaner;
    static int[][] map;
    
    static final int[] dr = { -1, 1, 0, 0 };
    static final int[] dc = { 0, 0, -1, 1 };
    
    static int cnt = 0;
    
    private static void simulate() {
        for (int i = 0; i < T; i++) {
            spread();
            cleaning();
        }
        
        counting();
    }
    
    private static void spread() {
        int[][] temp = new int[R][C];
    	
        for (int r = 0; r < R; r++) {
        	for (int c = 0; c < C; c++) {
        		if (map[r][c] == -1) {
        			temp[r][c] = -1;
        			continue;
        		}
        		
        		if (map[r][c] > 0) {
        			int cnt = 0;
        			for (int i = 0; i < 4; i++) {
        				int nr = r + dr[i];
        				int nc = c + dc[i];
        				
        				if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1) continue;
        				
        				temp[nr][nc] += map[r][c] / 5;
        				++cnt;
        			}
        			
        			temp[r][c] += map[r][c] - (map[r][c] / 5) * cnt; 
        		}
        	}
        }
        
        map = temp;
    }
    
    private static void cleaning() {
    	// 청정기 윗부분 가동
    	int top = cleaner;
    	
    	// 상 -> 하
    	for (int r = top-1; r > 0; r--) {
    		map[r][0] = map[r-1][0];
    	}
    	
    	// 우 -> 좌
    	for (int c = 0; c < C-1; c++) {
    		map[0][c] = map[0][c+1];
    	}
    	
    	// 하 -> 상
    	for (int r = 0; r < top; r++) {
    		map[r][C-1] = map[r+1][C-1];
    	}
    	
    	// 좌 -> 우
    	for (int c = C-1; c > 1; c--) {
    		map[top][c] = map[top][c-1];
    	}
    	
    	map[top][1] = 0;
    	
    	// 청정기 아랫부분 가동
    	int bottom = cleaner + 1;
    	
    	// 하 -> 상
    	for (int r = bottom+1; r < R-1; r++) {
    		map[r][0] = map[r+1][0];
    	}
    	
    	// 우 -> 좌
    	for (int c = 0; c < C-1; c++) {
    		map[R-1][c] = map[R-1][c+1];
    	}
    	
    	// 상 -> 하
    	for (int r = R-1; r > bottom; r--) {
    		map[r][C-1] = map[r-1][C-1];
    	}
    	
    	// 좌 -> 우
    	for (int c = C-1; c > 1; c--) {
    		map[bottom][c] = map[bottom][c-1];
    	}
    	
    	map[bottom][1] = 0;
    }
    
    private static void counting() {
    	for (int i = 0; i < R; i++) {
    		for (int j = 0; j < C; j++) {
    			if (map[i][j] > 0) cnt += map[i][j];
    		}
    	}
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];
        boolean flag = false;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (!flag && map[i][j] == -1) {
                    cleaner = i;
                    flag = true;
                }
            }
        }
        
        simulate();
        System.out.println(cnt);
    }

}