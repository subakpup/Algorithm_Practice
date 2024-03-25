import sys
input = sys.stdin.readline

for _ in range(int(input())):
    a = list(map(str,input().upper().rstrip()))
    res = 0
    score = 0
    for i in a:
        if i == 'O':
            score += 1
            res += score
        elif i == 'X':
            score = 0
    print(res)
