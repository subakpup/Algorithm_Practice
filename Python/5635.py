import sys
input = sys.stdin.readline

arr = []

for _ in range(int(input())):
    n,d,m,y = map(str,input().split())
    d,m,y = map(int,(d,m,y))
    arr.append((y,m,d,n))
arr.sort()
print(arr[-1][3])
print(arr[0][3])

# 5
# Mickey 1 10 1991
# Alice 30 12 1990
# Tom 15 8 1993
# Jerry 18 9 1990
# Garfield 20 9 1990