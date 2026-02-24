t = int(input())
for tc in range(1, t+1):
    n = int(input())
    o = [2,3,5,7,11]
    answer = [0, 0, 0, 0, 0]

    for i in range(5):
        while n % o[i] == 0:
            answer[i] += 1
            n //= o[i]
        answer[i] = str(answer[i])

    print(f'#{tc} {" ".join(answer)}')