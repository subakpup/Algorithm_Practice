import sys
input = sys.stdin.readline

k, n = map(int, input().split())
arr = [int(input()) for _ in range(k)]
l, r = 1, max(arr)

while l <= r:
    mid = (l + r) // 2
    cnt = 0
    for i in arr:
        cnt += i // mid
    if cnt >= n:
        l = mid + 1
    else:
        r = mid - 1
print(r)