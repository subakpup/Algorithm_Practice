n = int(input())
res = 666
cnt = 0

while True:
    if '666' in str(res):
        cnt += 1
    if cnt == n:
        break
    res += 1
print(res)