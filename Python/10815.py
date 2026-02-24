import sys
input = sys.stdin.readline

n = int(input())
nlist = set(map(int,input().split()))
m = int(input())
mlist = list(map(int,input().split()))

res = [1 if i in nlist else 0 for i in mlist]
print(*res)