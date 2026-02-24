import sys
input = sys.stdin.readline

def isPrime(n):
    if n < 2:
        return False
    for i in range(2, int(n**0.5)+1):
        if n % i == 0:
            return False
    return True

for i in range(int(input())):
    n = int(input())
    while True:
        if isPrime(n):
            print(n)
            break
        else:
            n += 1