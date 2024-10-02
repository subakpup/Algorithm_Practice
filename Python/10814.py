import sys
input = sys.stdin.readline

arr = [input().split() for _ in range(int(input()))]
arr.sort(key= lambda x: int(x[0]))
for i in arr: print(*i)