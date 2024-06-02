import sys
input = sys.stdin.readline

def dfs(start):
    if len(s) == m:
        print(*s)
        return
    o = 0
    for i in range(start, n):
        if o != arr[i]:
            s.append(arr[i])
            o = arr[i]
            dfs(i)
            s.pop()

n,m = map(int,input().split())
arr = sorted(list(map(int,input().split())))
s = []
dfs(0)