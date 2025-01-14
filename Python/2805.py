import sys
input = sys.stdin.readline

n,m = map(int,input().split())
tree = list(map(int,input().split()))
l,r = 1, max(tree)

while l <= r:
    mid = (l+r) // 2
    cnt = 0
    for i in tree:
        if i > mid:
            cnt += i - mid
    if cnt >= m:
        l = mid + 1
    else:
        r = mid - 1

print(r)