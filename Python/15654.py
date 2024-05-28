import sys
input = sys.stdin.readline

n,m = map(int,input().split())
arr = list(map(int,input().split()))
arr.sort()
s = []

def dfs():
    if len(s) == m:
        print(' '.join(map(str, s)))
        return
    
    for i in arr:
        if i not in s:
            s.append(i)
            dfs()
            s.pop()

dfs()