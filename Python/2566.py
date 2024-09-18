arr = [list(map(int,input().split())) for _ in range(9)]
mx = 0; row = 0; col = 0
for i in range(9):
    for j in range(9):
        if arr[i][j] > mx:
            mx = arr[i][j]
            row,col = i,j
print(mx)
print(row+1,col+1)