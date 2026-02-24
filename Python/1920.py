import sys
input = sys.stdin.readline

n = int(input())
N = list(map(int,input().split()))
N.sort()

m = int(input())
M = list(map(int,input().split()))

for i in M:
    l,r = 0, n-1
    while l <= r:
        mid = (l+r) // 2
        if N[mid] == i:
            print(1)
            break
        elif N[mid] < i:
            l = mid + 1
        else:
            r = mid - 1
    else:
        print(0)