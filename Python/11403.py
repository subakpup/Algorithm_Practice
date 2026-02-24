from collections import deque
import sys
input = sys.stdin.readline

def bfs(v):
    queue = deque([v])
    visited = [False] * n

    while queue:
        node = queue.popleft()
        for i in range(n):
            if graph[node][i] and not visited[i]:
                visited[i] = True
                res[v][i] = 1
                queue.append(i)

if __name__ == "__main__":
    n = int(input())
    graph = [list(map(int,input().split())) for _ in range(n)]
    res = [[0] * n for _ in range(n)]

    for i in range(n):
        bfs(i)

    for r in res:
        print(*r)