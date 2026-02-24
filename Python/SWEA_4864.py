t = int(input())
for tc in range(1, t+1):
    a = input()
    chk = input()
    
    answer = 0
    if a in chk:
        answer = 1
    print(f'#{tc} {answer}')