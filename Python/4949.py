while True:
    a = input()
    stk = []

    if a == '.':
        break

    for i in a:
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

    if not stk:
        print('yes')
    else:
        print('no')