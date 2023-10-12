from collections import deque
import sys
input = sys.stdin.readline
d = deque()

for i in range(int(input())):
    a = input().split()
    if a[0] == 'push_front':
        d.appendleft(a[1])
    elif a[0] == 'push_back':
        d.append(a[1])
    elif a[0] == 'pop_front':
        if d:
            print(d.popleft())
        else:
            print(-1)
    elif a[0] == 'pop_back':
        if d:
            print(d.pop())
        else:
            print(-1)
    elif a[0] == 'size':
        print(len(d))
    elif a[0] == 'empty':
        if not d:
            print(1)
        else:
            print(0)
    elif a[0] == 'front':
        if d:
            print(d[0])
        else:
            print(-1)
    elif a[0] == 'back':
        if d:
            print(d[-1])
        else:
            print(-1)    