t = int(input())
for tc in range(1, t+1):
    string = input()
    arr = []
    answer = 1
    for s in string:
        if s == '{' or s == '(':
            arr.append(s)
        elif s == '}':
            if arr and arr[-1] == '{':
                arr.pop()
            else:
                answer = 0
                break
        elif s == ')':
            if arr and arr[-1] == '(':
                arr.pop()
            else:
                answer = 0
                break
        
    if arr:
        answer = 0
        
    print(f'#{tc} {answer}')