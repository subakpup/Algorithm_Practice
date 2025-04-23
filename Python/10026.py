from collections import deque
import sys
input = sys.stdin.readline

def bfs(a,b,color,pic,visited):
    queue = deque([(a,b)])
    visited[a][b] = True
    
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                if pic[nx][ny] == 

if __name__ == "__main__":
    n = int(input())
    
    pic = [list(input()) for _ in range(n)]
    visited = [[False] * n for _ in range(n)]
    
    pic_blind = [[i if i == "B" else "G" for i in r] for r in pic]
    visited_blind = [[False] * n for _ in range(n)]