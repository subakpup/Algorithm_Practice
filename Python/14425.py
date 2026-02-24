import sys
input = sys.stdin.readline

n,m = map(int,input().split())
arr = set(input().rstrip() for _ in range(n))
arr2 = [input().rstrip() for _ in range(m)]

print(sum(1 for i in arr2 if i in arr))