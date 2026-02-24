import sys
input = sys.stdin.readline

n,k = map(int,input().split())
coin = [int(input()) for _ in range(n)]
coin.reverse()
cnt = 0

for i in coin:
    if k // i > 0:
        cnt += k // i
        k %= i
print(cnt)