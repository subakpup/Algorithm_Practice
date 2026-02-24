import sys
input = sys.stdin.readline

a,b,c = sorted(list(map(int,input().split())))
n,m = b-a,c-b
if n == m:
    print(c+n)
else:
    s = min(n,m)
    if n != s:
        print(b-s)
    else:
        print(c-s)