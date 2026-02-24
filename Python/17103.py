import sys
input = sys.stdin.readline

prime = [True for _ in range(1000001)]
prime[0] = prime[1] = False
for i in range(2, int(1000001 ** 0.5) + 1):
    if prime[i] == True:
        for j in range(i*2, 1000001, i):
            prime[j] = False

t = int(input())
for _ in range(t):
    n = int(input())
    pt = 0
    for num in range(2, n//2+1):
        if prime[num] and prime[n - num]:
            pt += 1
    print(pt)