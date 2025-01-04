import sys
input = sys.stdin.readline

n = int(input())
size = list(map(int,input().split()))
t,p = map(int,input().split())
cnt = 0

for i in size:
    if i % t == 0:
        cnt += i // t
    else:
        cnt += i // t + 1

print(cnt)
print(n//p, n%p)