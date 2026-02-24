x = []
y = []
for _ in range(3):
    a,b = map(int,input().split())
    x.append(a); y.append(b)

for i in range(3):
    if x.count(x[i]) == 1:
        resX = x[i]
    elif y.count(y[i]) == 1:
        resY = y[i]
print(resX, resY)