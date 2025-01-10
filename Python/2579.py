import sys
input = sys.stdin.readline

n = int(input())
arr = [int(input()) for _ in range(n)]
dp = [0] * n
dp[0] = arr[0]
dp[1] = arr[0] + arr[1]

for i in range(2,n):
    dp[i] = max()

print(dp)