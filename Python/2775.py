import sys
input = sys.stdin.readline

for tc in range(int(input())):
    k = int(input())
    n = int(input())
    dp = [i for i in range(1, n+1)]
    
    for _ in range(k):
        for i in range(1, n):
            dp[i] += dp[i-1]
    print(dp[-1])