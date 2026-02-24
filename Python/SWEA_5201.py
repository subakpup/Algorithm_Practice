t = int(input())
for tc in range(1, t+1):
    # 컨테이너, 트럭
    n,m = map(int,input().split())
    container = sorted(map(int,input().split()), reverse=True) # 화물 무게
    truck = sorted(map(int,input().split()), reverse=True) # 적재용량

    total = 0
    idx = 0
    for t in truck:
        while idx < n:
            if container[idx] <= t:
                total += container[idx]
                idx += 1
                break
            idx += 1

    print(f'#{tc} {total}')