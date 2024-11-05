import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

def dfs(x,y):
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False
    
    if graph[x][y] == 1:
        graph[x][y] = 0
        
        for i in range(4):
            dfs(x+dx[i], y+dy[i])
        return True
    
    return False

if __name__ == '__main__':
    for _ in range(int(input())):
        m,n,k = map(int,input().split())
        graph = [[0] * m for _ in range(n)]
        cnt = 0

        for i in range(k):
            x,y = map(int,input().split())
            graph[y][x] = 1
        
        for x in range(n):
            for y in range(m):
                if dfs(x,y):
                    cnt += 1
        
        print(cnt)