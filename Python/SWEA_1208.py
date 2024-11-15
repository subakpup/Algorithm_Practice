for tc in range(1,11):
    d = int(input())
    ground = list(map(int,input().split()))

    for i in range(d):
        max_idx = ground.index(max(ground))
        min_idx = ground.index(min(ground))
        ground[max_idx] -= 1
        ground[min_idx] += 1
    
    res = max(ground) - min(ground)

    print(f'#{tc} {res}')