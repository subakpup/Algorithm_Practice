import sys
input = sys.stdin.readline

n,k = map(int, input().split())
x = list(map(int, input().split()))
x.sort(reverse=True)

print(x[k-1])