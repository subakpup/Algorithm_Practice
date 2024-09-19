arr = [int(input()) for _ in range(5)]
res = []
for i in arr:
    if arr.count(i)%2 == 1:
        res.append(i)
res = list(set(res))
print(*res)