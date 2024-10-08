import sys
input = sys.stdin.readline

for i in range(int(input())):
    stk = []
    s = input().rstrip()
    for j in s:
        if j == '(':
            stk.append(j)
        elif j == ')':
            if stk:
                stk.pop()
            else:
                print('NO')
                break
    else:
        if stk:
            print('NO')
        else:
            print('YES')