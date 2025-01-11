import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n = int(input())
    dp = [0] * (n+1)
    dp[1:4] = 1, 2, 4
    if dp[n] == 0:
        for i in range(4, n+1):
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1]
    print(dp[n])

# f(1) = 1 = 1
# f(2) = 1+1, 2 = 2
# f(3) = 1+1+1, 1+2, 2+1, 3 = 4
# f(4) = 7
# f(5) = 1+1+1+1+1, 1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1, 1+2+2, 2+1+2, 2+2+1, 1+1+3, 1+3+1, 3+1+1, 2+3, 3+2 = 13