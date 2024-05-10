import sys
input = sys.stdin.readline

def factorial(n):
    if n == 0 or n == 1:
        return 1
    else:
        return n * factorial(n-1)

n = int(input())
arr = list(str(factorial(n)))
res = 0

for i in range(1, len(arr)+1):
    if arr[-i] == '0':
        res += 1
    else:
        print(res)
        break