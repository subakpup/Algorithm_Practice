import sys, math
input = sys.stdin.readline

def gcd(a,b):
    while b > 0:
        a,b = b,a%b
    return a

def lcm(a,b):
    return a * b // gcd(a,b)

a,b = map(int,input().split())
print(gcd(a,b))
print(lcm(a,b))
print(math.gcd(a,b))
print(math.lcm(a,b))