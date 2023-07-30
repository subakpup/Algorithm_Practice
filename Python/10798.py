arr = [input() for i in range(5)]       # 5줄 입력

# 첫 번째로 읽을 단어는 arr[0][0], 두 번째는 arr[1][0]
# 즉 왼쪽에서 오른쪽으로 읽는다.

for i in range(len(max(arr,key=len))):  # 가장 긴 열만큼 반복
    for j in range(5):                  # 안쪽은 5번만
        if i < len(arr[j]):             # i가 단어 길이보다 작으면 인덱스 범위 안에 있기 때문에 출력 가능
            print(arr[j][i],end='')