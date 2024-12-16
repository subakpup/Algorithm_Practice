# 한 번에 1 or 2 계단씩 오름
# 연속된 3개의 계단 밟으면 안 됨
# 마지막 계단은 무조건 밟아야 됨
import sys
input = sys.stdin.readline

if __name__ == "__main__":
    n = int(input())
    arr = [int(input()) for _ in range(n)]
    dp = [0] * n
    dp[0] = arr[0]
    dp[1] = arr[0] + arr[1]
    dp[2] = max(arr[0]+arr[2], arr[1]+arr[2])

    for i in range(3,n):
        dp[i] = max(dp[i-3])
    print(res)