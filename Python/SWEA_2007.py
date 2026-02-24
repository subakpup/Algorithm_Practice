t = int(input())
for tc in range(1,t+1):
    s = input()
    for i in range(1,11):
        if s[0:i] == s[i:i*2]:
            print(f'#{tc} {i}')
            break