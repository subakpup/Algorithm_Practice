s = int(input())
res = 0
cnt = 0
while res <= s:
    cnt += 1
    res += cnt
print(cnt-1)