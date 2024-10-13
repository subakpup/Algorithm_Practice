import sys
input = sys.stdin.readline

a,b = map(int,input().split())
res = list(range(min(a,b)+1, max(a,b)))
print(len(res))
print(*res)