t = int(input())
for tc in range(1, t+1):
    str1 = set(input())
    str2 = input()
    
    dic = dict()
    for s in str1:
        dic[s] = 0
    
    for d in dic.keys():
        if d in str2:
            dic[d] += 1
    
    answer = max(dic.values())
    
    print(f'#{tc} {answer}')