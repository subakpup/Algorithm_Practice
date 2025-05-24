t = int(input())
for tc in range(1, t+1):
    string = input()

    answer = []
    for s in string:
        if s in ['a', 'e', 'i', 'o', 'u']:
            continue
        answer.append(s)

    print(f'#{tc} {"".join(answer)}')