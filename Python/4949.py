import sys
input = sys.stdin.readline

while True:
    stk = []
    s = input().rstrip()
    
    if s == '.':
        break
    
    for i in s:
        if i == '(' or i == '[':
            stk.append(i)
        elif i == ')':
            if stk and stk[-1] == '(':
                stk.pop()
            else:
                stk.append(i)
                break
        elif i == ']':
            if stk and stk[-1] == '[':
                stk.pop()
            else:
                stk.append(i)
                break
    if stk:
        print('no')
    else:
        print('yes')