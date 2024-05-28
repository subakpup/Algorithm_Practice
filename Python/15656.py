import sys
input = sys.stdin.readline

n,m = map(int,input().split())
arr = sorted(list(map(int,input().split())))
s = []

def dfs():
    if len(s) == m:
        print(' '.join(map(str, s)))
        return
    
    for i in arr:
        s.append(i)
        dfs()
        s.pop()

dfs()