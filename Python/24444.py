from collections import deque
import sys
input = sys.stdin.readline

def bfs(graph,v,visited):
    global c
    queue = deque([v])
    visited[v] = 1
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if visited[i] == 0:
                queue.append(i)
                visited[i] = c
                c += 1

if __name__ == '__main__':
    n,m,v = map(int,input().split())
    visited = [0] * (n+1)
    cnt = [0] * (n+1)
    c = 1
    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        a,b = map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)
    
    for i in range(1, n+1):
        graph[i].sort()
    
    bfs(graph,v,visited)

    for j in range(1, n+1):
        print(cnt[j])