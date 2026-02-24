import sys
input = sys.stdin.readline

# 입력
n,m,k = map(int,input().split())
board = [input().rstrip() for _ in range(n)]

# 바꿔야 할 보드 개수(누적합 배열)
change = [[0] * (m+1) for _ in range(n+1)]

# 누적합 계산
for i in range(1, n+1):
    for j in range(1, m+1):
        tmp = board[i-1][j-1] # 현재 보드판의 위치
        color = 'W' if (i+j) % 2 == 0 else 'B' # (처음 칸이 흰색 기준)짝수 인덱스일 때 "W"
        add = 1 if tmp != color else 0 # 현재 보드판의 위치의 색이 올바르지 않을 경우 누적합 +1
        change[i][j] = change[i-1][j] + change[i][j-1] - change[i-1][j-1] + add

# 결과
res = 1e9

# k*k 영역의 다시 칠해야 하는 횟수 계산
for i in range(k,n+1):
    for j in range(k,m+1):
        white = change[i][j] - change[i-k][j] - change[i][j-k] + change[i-k][j-k]
        black = k * k - white
        res = min(res, white, black)

print(res)