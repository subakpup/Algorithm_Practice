import sys
from bisect import bisect_left, bisect_right
input = sys.stdin.readline

N = int(input())
n = sorted(map(int,input().split()))
M = int(input())
m = list(map(int,input().split()))

for i in m:
    rt = bisect_right(n,i)
    lt = bisect_left(n,i)
    print(rt - lt, end = ' ')