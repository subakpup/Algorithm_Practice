while True:
    n = int(input())        # 한 줄 간격 n
    if n == -1:             # 입력의 마지막
        break
    arr = []                # 약수를 넣을 빈 배열 생성

    for i in range(1,n):
        if n%i == 0:
            arr.append(i)   # 1부터 계산하기 때문에 오름차순으로 들어감
    
    if sum(arr) == n:       # n이 자신을 제외한 모든 약수들의 합과 같으면
        print(f'{n} =', ' + '.join(str(i) for i in arr))
    else:                   # 아닐 경우
        print(f'{n} is NOT perfect.')