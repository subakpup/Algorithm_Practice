n = int(input())
k = list(map(int,input().split()))
res = 0
for i in k:
    arr = []
    for j in range(1, i+1):
        if i % j == 0:
            arr.append(j)
    if len(arr) == 2:
        res += 1
print(res)