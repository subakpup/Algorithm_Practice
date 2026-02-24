import sys
input = sys.stdin.readline

def isPrime(n):
    if n < 2:
        return False
    else:
        for i in range(2, int(n**0.5)+1):
            if n % i == 0:
                return False
        return True

arr = [i for i in range(2, 246912)]
lst = []

for i in arr:
    if isPrime(i):
        lst.append(i)

n = int(input())

while True:
    if n == 0:
        break
    cnt = 0
    for i in lst:
        if n < i <= 2*n:
            cnt += 1
    print(cnt)
    n = int(input())