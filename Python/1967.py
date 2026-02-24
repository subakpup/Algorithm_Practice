from collections import deque
import sys
input = sys.stdin.readline

def bfs(start):
    global n
    queue = deque([start])
    visited = [-1] * (n+1)
    visited[start] = 0
    
    while queue:
        cur = queue.popleft()
        
        for node,weight in graph[cur]:
            if visited[node] == -1:
                visited[node] = visited[cur] + weight
                queue.append(node)
    
    return visited.index(max(visited)), max(visited)

if __name__ == "__main__":
    n = int(input())
    graph = [[] for _ in range(n+1)]
    for _ in range(n-1):
        p,c,w = map(int,input().split())
        graph[p].append((c,w))
        graph[c].append((p,w))
        
    idx,_ = bfs(1)
    _,dis = bfs(idx)
    
    print(dis)    