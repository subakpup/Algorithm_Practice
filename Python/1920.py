import sys
input = sys.stdin.readline

a = int(input())
n = list(map(int,input().split()))
aa = int(input())
m = list(map(int,input().split()))
n.sort()

for i in m:
    if m