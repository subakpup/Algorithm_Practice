# 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
from collections import deque
import sys
input = sys.stdin.readline

def bfs():
    dx = [-1,1,0,0,0,0]
    dy = [0,0,-1,1,0,0]
    dz = [0,0,0,0,-1,1]
    
    while queue:
        x,y,z = queue.popleft()
        
        for i in range(6):
            nx,ny,nz = x+dx[i],y+dy[i],z+dz[i]
            if 0 <= nx < h and 0 <= ny < n and 0 <= nz < m and box[nx][ny][nz] == 0:
                queue.append((nx,ny,nz))
                box[nx][ny][nz] = box[x][y][z] + 1

if __name__ == "__main__":
    m,n,h = map(int,input().split()) # 가로, 세로, 높이
    
    box = [[list(map(int,input().split())) for _ in range(n)] for _ in range(h)]
    
    queue = deque()
    for i in range(h):
        for j in range(n):
            for k in range(m):
                if box[i][j][k] == 1:
                    queue.append((i,j,k))
                
    bfs()
    
    res = 0
    for a in box:
        for b in a:
            if 0 in b:
                print(-1)
                exit()
            res = max(res, max(b))
    print(res -1)