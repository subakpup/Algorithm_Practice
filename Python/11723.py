import sys
input = sys.stdin.readline

s = set()
for _ in range(int(input())):
    x = input().split()
    a = x[0]
    if a == 'add':
        s.add(int(x[1]))
    elif a == 'remove':
        s.discard(int(x[1]))
    elif a == 'check':
        print(1 if int(x[1]) in s else 0)
    elif a == 'toggle':
        if int(x[1]) in s:
            s.discard(int(x[1]))
        else:
            s.add(int(x[1]))
    elif a == 'all':
        s = set(range(1,21))
    elif a == 'empty':
        s.clear()
