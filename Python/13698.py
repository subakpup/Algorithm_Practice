s = input()
arr = [1,0,0,2]

for i in range(len(s)):
    if s[i] == 'A':
        arr[0], arr[1] = arr[1], arr[0]
    elif s[i] == 'B':
        arr[0], arr[2] = arr[2], arr[0]
    elif s[i] == 'C':
        arr[0], arr[3] = arr[3], arr[0]
    elif s[i] == 'D':
        arr[1], arr[2] = arr[2], arr[1]
    elif s[i] == 'E':
        arr[1], arr[3] = arr[3], arr[1]
    elif s[i] == 'F':
        arr[2], arr[3] = arr[3], arr[2]
print(arr.index(1)+1)
print(arr.index(2)+1)