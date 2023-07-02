arr = [input() for i in range(5)]       # 5줄 입력

for i in range(len(max(arr,key=len))):  # 가장 긴 열만큼 반복
    for j in range(5):                  # 안쪽은 5번만
        if i < len(arr[j]):
            print(arr[j][i],end='')