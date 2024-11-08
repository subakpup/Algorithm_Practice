n = int(input())
arr = list(map(int,input().split()))
arr.sort()
cnt = 0
res = 0
for i in arr:
    cnt += i
    res += cnt
print(res)