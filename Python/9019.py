from collections import deque
import sys
input = sys.stdin.readline

def bfs(a,b):
    visited = [False] * 10000
    queue = deque([(a, "")])
    visited[a] = True
    
    while queue:
        cur, cmd = queue.popleft()
        
        if cur == b:
            return cmd
        
        D = (cur * 2) % 10000
        if not visited[D]:
            visited[D] = True
            queue.append((D, cmd + 'D'))
        
        S = cur - 1 if cur > 0 else 9999
        if not visited[S]:
            visited[S] = True
            queue.append((S, cmd + 'S'))
        
        L = (cur % 1000) * 10 + (cur // 1000)
        if not visited[L]:
            visited[L] = True
            queue.append((L, cmd + 'L'))
            
        R = (cur % 10) * 1000 + (cur // 10)
        if not visited[R]:
            visited[R] = True
            queue.append((R, cmd + 'R'))

t = int(input())
for _ in range(t):
    a,b = map(int,input().split())
    print(bfs(a,b))