import sys
input = sys.stdin.readline

def factorial(x):
    if x == 0 or x == 1:
        return 1
    else:
        return x * factorial(x-1)

for _ in range(int(input())):
    n,m = map(int,input().split())
    print(factorial(m) // (factorial(n) * factorial(m-n)))