import sys, math
input = sys.stdin.readline

a,b = map(int,input().split())
c,d = map(int,input().split())

top = a*d+b*c
bottom = b*d
lcm = math.gcd(top,bottom)
top //= lcm
bottom //= lcm
print(top, bottom)