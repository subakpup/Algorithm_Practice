import sys
input = sys.stdin.readline

def dfs():
    if len(s) == m:
        print(*s)
        return
    o = 0
    for i in range(n):
        if o != arr[i]:
            s.append(arr[i])
            o = arr[i]
            dfs()
            s.pop()

n,m = map(int,input().split())
arr = sorted(list(map(int,input().split())))
s = []
dfs()