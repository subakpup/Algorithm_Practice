from collections import deque
import sys
input = sys.stdin.readline

def bfs(start):
    queue = deque([start])
    while queue:
        node = queue.popleft()
        for v in graph[node]:
            if visited[v] == 0:
                visited[v] = node
                queue.append(v)

if __name__ == "__main__":
    n = int(input())
    graph = [[] for _ in range(n+1)]
    visited = [0] * (n + 1)
    
    for _ in range(n-1):
        a,b = map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)
        
    bfs(1)
    
    for i in range(2, n+1):
        print(visited[i])