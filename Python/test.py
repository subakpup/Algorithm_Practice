import sys
input = sys.stdin.readline

n = int(input())
dp = [0] * (n+1)
dp[1] = 9
if n >= 2:
    for i in range(2, n+1):
        dp[i] = dp[i-1] * 2 - (i-1)
print(dp[n]%1000000000)
