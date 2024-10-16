import sys
input = sys.stdin.readline

def factorial(x):
    if x == 0 or x == 1:
        return 1
    else:
        return x * factorial(x-1)

n,k = map(int,input().split())
print(factorial(n) // (factorial(n-k) * factorial(k)))