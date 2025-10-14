import java.util.*;
import java.io.*;

public class Main_1888 {
    static int m, n;
    static int[][] map;
    
    static final int[] dr = { -1, 1, 0, 0 };
    static final int[] dc = { 0, 0, -1, 1 };
    
    private static int simulate() {
    	int time = 0;
    	
    	while (!connected()) {
    		time++;
    		spread();
    	}
    	
    	return time;
    }
    
    private static boolean connected() {
    	int total = 0;
    	int sr = -1, sc = -1;
    	
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (map[i][j] != 0) {
    				total++;
    				sr = i; sc = j;
    			}
    		}
    	}
    	
    	return total == bfs(sr, sc);
    }
    
    private static int bfs(int sr, int sc) {
    	Queue<int[]> queue = new ArrayDeque<>();
    	boolean[][] visited = new boolean[m][n];
    	queue.add(new int[] { sr, sc });
    	visited[sr][sc] = true;
    	
    	int cnt = 1;
    	
    	while (!queue.isEmpty()) {
    		int[] cur = queue.poll();
    		int r = cur[0], c = cur[1];
    		
    		for (int i = 0; i < 4; i++) {
    			int nr = r + dr[i], nc = c + dc[i];
    			
    			if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
    			if (map[nr][nc] == 0 || visited[nr][nc]) continue;
    			
    			visited[nr][nc] = true;
    			queue.add(new int[] { nr, nc });
    			cnt++;
    		}
    	}
    	
    	return cnt;
    }
    
    private static void spread() {
        int[][] nxt = new int[m][n];
        for (int r = 0; r < m; r++) {
        	for (int c = 0; c < n; c++) {
        		int k = map[r][c];
        		
        		if (k == 0) continue;
        		
        		int r0 = Math.max(0, r - k), r1 = Math.min(m - 1, r + k);
        		int c0 = Math.max(0, c - k), c1 = Math.min(n - 1, c + k);
        		
        		for (int nr = r0; nr <= r1; nr++) {
        			for (int nc = c0; nc <= c1; nc++) {
        				if (nxt[nr][nc] == 0) nxt[nr][nc] = k;
        			}
        		}
        	}
        }
        map = nxt;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        map = new int[m][n];
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';             
            }
        }
        
        System.out.println(simulate());
        
    }

}