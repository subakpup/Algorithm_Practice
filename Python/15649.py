import sys
input = sys.stdin.readline

def dfs():
    if len(arr) == m:
        print(arr)
    return 

n,m = map(int,input().split())
arr = []
visited = [False] * (n+1)

