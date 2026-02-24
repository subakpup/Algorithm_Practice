alpha = 'abcdefghijklmnopqrstuvwxyz'
res = [0] * len(alpha)
s = input()
for i in s:
    if i in alpha:
        res[alpha.index(i)] += 1
print(*res)