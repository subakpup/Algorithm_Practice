n = int(input())
cnt = 0
for i in range(1, n+1):
    cnt += i
res = 0
for i in range(1, n+1):
    res += i**3
print(cnt)
print(cnt**2)
print(res)