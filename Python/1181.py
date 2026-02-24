import sys
input = sys.stdin.readline

arr = sorted(set(input().rstrip() for _ in range(int(input()))))
arr.sort(key=len)
for j in arr: print(j)