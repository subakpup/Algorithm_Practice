import sys
input = sys.stdin.readline

while True:
    s = input().rstrip()
    cnt1 = 0
    cnt2 = 0
    if s == '.':
        break
    for i in s:
        if i == '(':
            cnt1 += 1
        elif i == ')':
            cnt1 -= 1
        elif i == '[':
            cnt2 += 1
        elif i == ']':
            cnt2 -= 1
    if cnt1 == 0 and cnt2 == 0:
        print('yes')
    else:
        print('no')