import sys
input = sys.stdin.readline
a,b = map(int,input().split())
mn = min(a,b)
mx = max(a,b)
arr = [i for i in range(mn+1, mx)]
print(len(arr))
print(*arr)