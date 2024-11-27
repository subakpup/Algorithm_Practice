import sys
input = sys.stdin.readline

def fibo(n):
    f[1] = f[2] = 1
    for i in range(3, n+1):
        f[i] = f[i-2] + f[i-1]
    return f[n]

if __name__ == "__main__":
    n = int(input())
    f = [0] * (n+1)
    print(fibo(n), n-2)