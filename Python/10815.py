from bisect import bisect_left, bisect_right
import sys
input = sys.stdin.readline

input()
n = sorted(map(int,input().split()))
input()
m = list(map(int,input().split()))

for i in m:
    lt = bisect_left(n,i)
    rt = bisect_right(n,i)
    print(rt - lt,end = " ")