import sys
input = sys.stdin.readline

a = sorted(map(int,input().split()))
print(a[0]+a[1]+min(a[2],a[0]+a[1]-1))