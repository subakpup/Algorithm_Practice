import sys
input = sys.stdin.readline

def dfs(start):
    chk = 0
    if len(s) == m:
        print(*s)
        return
    for i in range(start, n):
        if arr[i] != chk and not visited[i]:
            s.append(arr[i])
            visited[i] = True
            chk = arr[i]
            dfs(i+1)
            visited[i] = False
            s.pop()

if __name__ == '__main__':
    n,m = map(int,input().split())
    arr = sorted(map(int,input().split()))
    s = []
    visited = [False] * n
    dfs(0)