arr = []

for i in range(10):
    tmp = []
    for i in range(10):
        tmp.append(0)
    arr.append(tmp)

for i in range(2):
    for j in range(4, 6):
        arr[i][j] = 1

for i in range(10):
    print(*arr[i])