import math
a,b = map(int,input().split())
c,d = map(int,input().split())

n = a*d + b*c
m = b*d
g = math.gcd(n,m)
print(n//g, m//g)