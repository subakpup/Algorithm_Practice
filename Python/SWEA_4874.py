t = int(input())
for tc in range(1, t+1):
    forth = list(input().split())
    arr = []
    answer = 'error'

    for s in forth:
        if s.isdigit():
            arr.append(int(s))
        elif s == '.':
            if len(arr) == 1:
                answer = arr[0]
            break
        else:
            if len(arr) < 2:
                break
            n2 = arr.pop()
            n1 = arr.pop()
            if s == '+':
                arr.append(n1 + n2)
            elif s == '-':
                arr.append(n1 - n2)
            elif s == '*':
                arr.append(n1 * n2)
            elif s == '/':
                arr.append(n1 // n2)
            else:
                break

    print(f'#{tc} {answer}')