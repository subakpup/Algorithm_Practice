import sys
input = sys.stdin.readline

def func(n,arr):
    for i in range(n):
        dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + arr[i][0]
        dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + arr[i][1]
        dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + arr[i][2]

if __name__ == "__main__":
    n = int(input())
    arr = [list(map(int,input().split())) for _ in range(n)]
    dp = [[0] * 3 for _ in range(n)]
    dp[0] = arr[0]
    func(n,arr)
    print(min(dp[-1]))