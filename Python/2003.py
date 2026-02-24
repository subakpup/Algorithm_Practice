import sys
input = sys.stdin.readline

def func(n,m,a):
    l,r = 0,1
    cnt = 0

    while r <= n and l <= r:
        total = sum(a[l:r])
    
        if total == m:
            cnt += 1
            r += 1
        elif total > m:
            l += 1
        else:
            r += 1
        
    return cnt

if __name__ == "__main__":
    n,m = map(int,input().split())
    a = list(map(int,input().split()))
    print(func(n,m,a))