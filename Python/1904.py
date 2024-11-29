import sys
input = sys.stdin.readline

def func(n):
    dp[1] = 1
    dp[2] = 2
    for i in range(3, n+1):
        dp[i] = (dp[i-2] + dp[i-1]) % 15746
    return dp[n]

if __name__ == "__main__":
    n = int(input())
    dp = [0] * 1000001
    print(func(n))