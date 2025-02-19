import sys
input = sys.stdin.readline

def gcd(a,b):
    while b:
        a,b = b,a%b
    return a

def lcm(a,b):
    return a*b // gcd(a,b)

def func(m,n,x,y):
    limit = lcm(m,n)

    while x <= limit:
        if (y-x) % n == 0:
            return x
        x += m

    return -1

if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        m,n,x,y = map(int,input().split())
        print(func(m,n,x,y))