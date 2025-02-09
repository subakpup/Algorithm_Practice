import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int,input().split()))
cnt = {}
left,res = 0,0

for right in range(n):
    cnt[arr[right]] = cnt.get(arr[right], 0) + 1

    while len(cnt) > 2:
        cnt[arr[left]] -= 1
        if cnt[arr[left]] == 0:
            del cnt[arr[left]]
        left += 1

    res = max(res, right - left + 1)

print(res)