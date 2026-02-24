import sys
input = sys.stdin.readline

# dir 0: 가로, 1: 세로, 2: 대각선
def dfs(r, c, dir):
    global answer

    if r == n - 1 and c == n - 1:
        answer += 1
        return
    
    if dir == 0 or dir == 2: # 가로 이동
        if c + 1 < n and graph[r][c+1] == 0:
            dfs(r, c + 1, 0)
    
    if dir == 1 or dir == 2: # 세로 이동
        if r + 1 < n and graph[r + 1][c] == 0:
            dfs(r + 1, c, 1)

    if r + 1 < n and c + 1 < n:
        if graph[r+1][c] == graph[r][c+1] == graph[r+1][c+1] == 0:
            dfs(r + 1, c + 1, 2)


if __name__ == "__main__":
    n = int(input())
    graph = [list(map(int,input().split())) for _ in range(n)]
    answer = 0

    dfs(0,1,0)
    print(answer)
