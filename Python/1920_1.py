from bisect import bisect_left, bisect_right
import sys
input = sys.stdin.readline

N = int(input())
n = sorted(list(map(int,input().split())))
M = int(input())
m = list(map(int,input().split()))
for i in m:
    rt = bisect_right(n, i)
    lt = bisect_left(n, i)
    if rt > lt:
        print(1)
    else:
        print(0)