import sys
input = sys.stdin.readline

n,m = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(n)]

num = [[0] * (n+1) for _ in range(n+1)]

for i in range(1,n+1):
    for j in range(1,n+1):
        num[i][j] = arr[i-1][j-1] + num[i-1][j] + num[i][j-1] - num[i-1][j-1]

for _ in range(m):
    x1,y1,x2,y2 = map(int,input().split())
    print(num[x2][y2] - num[x1-1][y2] - num[x2][y1-1] + num[x1-1][y1-1])