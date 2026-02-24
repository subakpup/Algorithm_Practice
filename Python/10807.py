import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int,input().split()))
v = int(input())
print(a.count(v))