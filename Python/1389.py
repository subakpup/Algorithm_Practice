from collections import deque
import sys
input = sys.stdin.readline

def bfs(v):
    queue = deque([v])
    visited = [-1] * (n+1) 
    visited[v] = 0

    while queue:
        node = queue.popleft()
        for i in graph[node]:
            if visited[i] == -1:
                queue.append(i)
                visited[i] = visited[node] + 1
    
    return sum(visited[1:])

if __name__ == "__main__":
    n,m = map(int,input().split())
    
    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        a,b = map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)

    val = 1e9
    res = 0

    for i in range(1,n+1):
        num = bfs(i)
        if num < val:
            val = num
            res = i
    
    print(res)