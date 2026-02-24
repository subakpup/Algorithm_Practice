a = int(input()); b = int(input()); c = int(input())
res = str(a*b*c)
for i in range(10):
    print(res.count(str(i)))