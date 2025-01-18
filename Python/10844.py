import sys
input = sys.stdin.readline

n = int(input())
dp = [[0] * 10 for _ in range(n+1)]
mod = 1000000000

# 1 2 3 4 5 6 7 8 9
# 10 12 21 23 32 34 43 45 54 56 65 67 76 78 87 89 90

for i in range(1, 10):
    dp[1][i] = 1

for i in range(2, n+1):
    for j in range(10):
        if j == 0:
            dp[i][j] = dp[i-1][j] % mod
        elif j == 9