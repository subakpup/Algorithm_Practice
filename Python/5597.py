n = [i for i in range(1,31)]

for i in range(28):
    cnt = int(input())
    n.remove(cnt)

for j in n:
    print(j)