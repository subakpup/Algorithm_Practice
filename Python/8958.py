for _ in range(int(input())):
    a = input()
    score = 0
    cnt = 0
    for i in range(len(a)):
        if a[i] == 'O':
            cnt += 1
        else:
            cnt = 0
        score += cnt
    print(score)