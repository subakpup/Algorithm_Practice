arr = [i for i in range(1, int(input())+1)]
for i in range(len(arr)):
    if str(arr[i]) in '3':
        arr[i] = '-' * str(arr[i]).count('3')
print(*arr)