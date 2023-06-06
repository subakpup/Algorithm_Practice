n = 0
x = 0
y = 0
for i in range(9):
    arr = list(map(int,input().split()))
    if max(arr) > n:
        n = max(arr)
        x = i
        y = arr.index(n)
print(n)
print(x+1,y+1)