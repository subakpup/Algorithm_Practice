arr = [input() for i in range(5)]

for j in range(len(max(arr,key=len))):
    for i in range(5):
        if j < len(arr[i]):
            print(arr[i][j],end='')