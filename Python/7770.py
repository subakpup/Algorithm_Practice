import sys
input = sys.stdin.readline

n = int(input())
cnt = 1
res = 0

while True:
    res += cnt**2 + (cnt-1)**2
    if res > n:
        print(cnt-1)
        break
    cnt += 1