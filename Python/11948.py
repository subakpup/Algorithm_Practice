arr1 = []
arr2 = []
for i in range(4):
    arr1.append(int(input()))
for i in range(2):
    arr2.append(int(input()))
arr1.remove(min(arr1))
print(sum(arr1) + max(arr2))