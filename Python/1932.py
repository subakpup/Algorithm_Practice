import sys
input = sys.stdin.readline

def func(n,arr):
    for i in range(n):
        dp[i] = dp[i-1] + max(arr[i])
        print(max(arr[i]))

if __name__ == "__main__":
    n = int(input())
    arr = [list(map(int,input().split())) for _ in range(n)]
    dp = [0] * n
    dp[0] = arr[0]
    func(n,arr)
    print(dp)