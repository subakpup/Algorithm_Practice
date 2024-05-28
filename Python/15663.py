import sys
input = sys.stdin.readline

n,m = map(int,input().split())
arr = sorted(list(map(int,input().split())))
s = []

def dfs():
    if len(s) == m:
        print(*s)
        return
    
    for i in arr:
        if i not in s:
            s.append(i)
            dfs()
            s.pop()
dfs()