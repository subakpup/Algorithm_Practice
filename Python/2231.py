n = int(input())
res = 0

for i in range(1, n):
    chk = i
    i = str(i)
    for j in i:
        chk += int(j)
    if chk == n:
        res = i
        break
print(res)