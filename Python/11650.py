import sys
input = sys.stdin.readline
arr = sorted([list(map(int,input().split())) for _ in range(int(input()))])
for i in arr: print(*i)