import sys
input = sys.stdin.readline

def bfs(si, sj, ei, ej):
    q = []
    v = [[0]*m for _ in range(n)]
    
    q.append((si, sj))
    v[si][sj] = 1
    
    while q:
        ci

n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]

ans = bfs(0, 0, n-1, m-1)