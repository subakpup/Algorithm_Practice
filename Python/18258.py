import sys
from collections import deque
input = sys.stdin.readline

queue = deque([])

for i in range(int(input())):
    a = list(map(str,input().split()))
    if a[0] == 'push':
        queue.append(int(a[1]))
    elif a[0] == 'pop':
        if queue:
            print(queue.popleft())
        else:
            print(-1)
    elif a[0] == 'size':
        print(len(queue))
    elif a[0] == 'empty':
        if not queue:
            print(1)
        else:
            print(0)
    elif a[0] == 'front':
        if queue:
            print(queue[0])
        else:
            print(-1)
    elif a[0] == 'back':
        if queue:
            print(queue[-1])
        else:
            print(-1)