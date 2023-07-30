import sys
input = sys.stdin.readline

def factorial(a):
    result = 1
    for i in range(1, a+1):
        result *= i
    return result

for _ in range(int(input())):
    n,m = map(int,input().split())
    print(factorial(m) // (factorial(m-n) * factorial(n)))