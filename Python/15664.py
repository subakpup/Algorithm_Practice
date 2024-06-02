import sys
input = sys.stdin.readline

def dfs(start):
    if len(s) == m:
        print(*s)
        return
    o = 0
    for i in range(start, n):
        if not visited[i] and o != arr[i]:
            visited[i] = True
            s.append(arr[i])
            o = arr[i]
            dfs(i+1)
            visited[i] = False
            s.pop()

n,m = map(int,input().split())
arr = sorted(list(map(int,input().split())))
s = []
visited = [False] * n
dfs(0)