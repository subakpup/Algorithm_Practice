import sys
input = sys.stdin.readline

N = int(input())
n = sorted(list(map(int,input().split())))
M = int(input())
m = list(map(int,input().split()))

for i in m:
    lt = 0
    rt = N - 1
    
    while lt <= rt:
        mid = (lt+rt)//2
        if n[mid] == i:
            print(1)
            break
        elif n[mid] < i:
            lt = mid + 1
        else:
            rt = mid - 1
    else:
        print(0)