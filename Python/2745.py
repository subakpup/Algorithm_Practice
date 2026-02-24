num = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'
n,b = input().split()
n = list(reversed(n))
res = 0
for i in range(len(n)):
    res += int(b) ** i * num.index(n[i])
print(res)