t = int(input())
for tc in range(1, t+1):
    n = int(input())
    trees = list(map(int,input().split()))
    
    target = max(trees)
    
    cnt1, cnt2 = 0
    for h in trees:
        d = target - h
        cnt1 += d % 2
        cnt2 += d // 2
    
    day = 0
    while cnt1 > 0 and cnt2 > 0:
        day += 1
        if day % 2 == 0:
            if cnt2 > 0:
                cnt2 -= 1
            elif cnt1 > 1:
                cnt1 -= 2
            elif cnt1 == 1:
                cnt1 -= 1
        else:
            if cnt1 > 0:
                cnt1 -= 1
            
    
    
    print(f'#{tc} {day}')