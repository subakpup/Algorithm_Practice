arr = [int(input()) for _ in range(9)]
for i in range(9):
    for j in range(i+1, 9):
        if sum(arr) - arr[i] - arr[j] == 100:
            for k in range(9):
                if k not in [i,j]:
                    print(arr[k])