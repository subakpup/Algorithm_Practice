from collections import deque
import sys
input = sys.stdin.readline

def bfs(board):
    visited = [False] * 101
    queue = deque([(1,0)])
    visited[1] = True
    
    while queue:
        loc, cnt = queue.popleft()
        if loc == 100:
            return cnt
        
        for d in range(1,7):
            next_loc = loc + d
            if next_loc > 100:
                continue
            
            if board[next_loc] != 0:
                next_loc = board[next_loc]
            
            if not visited[next_loc]:
                visited[next_loc] = True
                queue.append((next_loc, cnt + 1))

if __name__ == "__main__":
    n,m = map(int,input().split())
    board = [0] * 101
    
    for _ in range(n):
        x,y = map(int,input().split())
        board[x] = y
    
    for _ in range(m):
        u,v = map(int,input().split())
        board[u] = v
    
    print(bfs(board))