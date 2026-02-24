import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int,input().split()))

arr = sorted((v, i) for i, v in enumerate(a))

p = [0 for _ in range(n)]

for idx, (v, i) in enumerate(arr):
    p[i] = idx

print(*p)