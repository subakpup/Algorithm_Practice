import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int,input().split()))
reverse = arr[::-1]

dp_r = [1] * n
dp_l = [1] * n
res = [0] * n

for i in range(1,n):
    for j in range(i):
        if arr[i] > arr[j]:
            dp_r[i] = max(dp_r[i], dp_r[j]+1)
        if reverse[i] > reverse[j]:
            dp_l[i] = max(dp_l[i], dp_l[j]+1)

for i in range(n):
    res[i] = dp_r[i] + dp_l[n-i-1] - 1

print(dp_r)
print(dp_l[::-1])