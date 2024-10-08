a = set(range(1, 10001))
n = set()

for i in range(1, 10001):
    for j in str(i):
        i += int(j)
    n.add(i)

res = sorted(a-n)
for k in res: print(k)