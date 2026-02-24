import sys
input = sys.stdin.readline

stk = []
for i in range(int(input())):
    a = input().split()
    if a[0] == '1': 
        stk.append(a[1])
    elif a[0] == '2':
        print(stk.pop() if stk else -1)
    elif a[0] == '3':
        print(len(stk))
    elif a[0] == '4':
        print(0 if stk else 1)
    elif a[0] == '5':
        print(stk[-1] if stk else -1)