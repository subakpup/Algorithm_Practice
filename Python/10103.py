import sys
input = sys.stdin.readline

asum = bsum = 100

for i in range(int(input())):
    a,b = map(int,input().split())
    if a > b:
        bsum -= a
    elif a < b:
        asum -= b
    else:
        continue
print(asum, bsum, sep='\n')