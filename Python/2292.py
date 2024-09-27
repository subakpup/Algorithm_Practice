n = int(input())
comb = 1
cnt = 1

while n > comb:
    comb += 6 * cnt
    cnt += 1
print(cnt)