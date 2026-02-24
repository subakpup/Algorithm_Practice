import sys
input = sys.stdin.readline

def dfs(a,idx):
    global res
    if a == n//2:
        start,link = 0,0
        for i in range(n):
            for j in range(n):
                if visited[i] and visited[j]:
                    start += arr[i][j]
                elif not visited[i] and not visited[j]:
                    link += arr[i][j]
        res = min(res, abs(start-link))
        return
    else:
        for i in range(idx,n):
            if not visited[i]:
                visited[i] = True
                dfs(a+1, i+1)
                visited[i] = False


if __name__ == "__main__":
    n = int(input())
    arr = [list(map(int,input().split())) for _ in range(n)]
    visited = [False] * n
    res = 1e9

    dfs(0,0)
    print(res)    