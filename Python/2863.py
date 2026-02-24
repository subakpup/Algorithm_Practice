import sys
input = sys.stdin.readline

a,b = map(int,input().split())
c,d = map(int,input().split())

num = [a/c + b/d, c/d + a/b, d/b + c/a, b/a + d/c]
print(num.index(max(num)))