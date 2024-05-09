import sys
input = sys.stdin.readline

stk = []

for i in range(int(input())):
    a = list(map(int,input().split()))
    if a[0] == 1:
        stk.append(a[1])
    elif a[0] == 2:
        if stk:
            print(stk.pop())
        else:
            print(-1)
    elif a[0] == 3:
        print(len(stk))
    elif a[0] == 4:
        if not stk:
            print(1)
        else:
            print(0)
    elif a[0] == 5:
        if stk:
            print(stk[-1])
        else:
            print(-1)