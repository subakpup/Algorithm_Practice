import sys
input = sys.stdin.readline

def func(n):
    dp[1:11] = 1, 1, 1, 2, 2, 3, 4, 5, 7, 9
    if dp[n]:
        return dp[n]
    for i in range(11, n+1):
        dp[i] = dp[i-2] + dp[i-3]
    return dp[n]

if __name__ == "__main__":
    dp = [0] * 101
    for i in range(int(input())):
        n = int(input())
        print(func(n))