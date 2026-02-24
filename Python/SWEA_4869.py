t = int(input())
for tc in range(1, t+1):
    n = int(input())
    
    dp = [0] * (n+1)
    dp[10] = 1
    dp[20] = 3
    
    for i in range(30, n+1, 10):
        dp[i] = dp[i-10] + 2 * dp[i-20]
    
    print(f'#{tc} {dp[n]}')