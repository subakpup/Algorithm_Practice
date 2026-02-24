import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int,input().split()))
b = list(map(int,input().split()))

cnt = 0
for i in range(n):
    cnt += abs(a[i]-b[i])
print(cnt//2)