import sys
input = sys.stdin.readline
res = []
for i in range(int(input())):
    arr = sorted(list(map(int,input().split())))
    if arr[0] == arr[1] == arr[2]:
        res.append(10000 + arr[0] * 1000)
    elif arr[0] == arr[1] or arr[1] == arr[2]:
        res.append(1000 + arr[1] * 100)
    else:
        res.append(max(arr) * 100)
print(max(res))