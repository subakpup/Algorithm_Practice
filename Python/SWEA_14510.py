for tc in range(1, int(input())+1):
    n = int(input())
    trees = list(map(int, input().split()))

    max_height = max(trees)
    heights = [max_height - h for h in trees]
    total_height = sum(heights)

    if not total_height:
        print(f'#{tc} 0')
        continue

    even = 0
    for height in heights:
        even += height // 2
    
    days = int(1e9)
    for i in range(even + 1):
        cnt1 = total_height - i * 2
        cnt2 = i
        days = min(days, max(cnt1 * 2 - 1, cnt2 * 2))
    
    print(f'#{tc} {days}')