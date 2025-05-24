t = int(input())
for tc in range(1, t+1):
    n,l = map(int,input().split())

    # 점수, 칼로리
    arr = [list(map(int,input().split())) for _ in range(n)]

    dp = [0] * (l+1)

    for score, cal in arr:
        for i in range(l, cal - 1, -1):
            dp[i] = max(dp[i], dp[i-cal] + score)
    print(f'#{tc} {dp[-1]}')