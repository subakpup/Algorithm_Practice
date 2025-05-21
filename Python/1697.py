from collections import deque
import sys
input = sys.stdin.readline

def bfs():
    queue = deque([n])
    visited[n] = 0

    while queue:
        x = queue.popleft()
        if x == k:
            return visited[x]
        
        for nx in (x-1,x+1,x*2):
            if 0 <= nx <= MAX and visited[nx] == -1:
                queue.append(nx)
                visited[nx] = visited[x] + 1

if __name__ == "__main__":
    n,k = map(int,input().split())
    MAX = 100000
    visited = [-1] * (MAX+1)

    print(bfs())