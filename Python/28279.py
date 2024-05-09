from collections import deque
import sys
input = sys.stdin.readline

queue = deque([])

for i in range(int(input())):
    a = list(map(str,input().split()))
    if a[0] == '1':
        queue.appendleft(int(a[1]))
    elif a[0] == '2':
        queue.append(int(a[1]))
    elif a[0] == '3':
        if queue:
            print(queue.popleft())
        else:
            print(-1)
    elif a[0] == '4':
        if queue:
            print(queue.pop())
        else:
            print(-1)
    elif a[0] == '5':
        print(len(queue))
    elif a[0] == '6':
        if not queue:
            print(1)
        else:
            print(0)
    elif a[0] == '7':
        if queue:
            print(queue[0])
        else:
            print(-1)
    elif a[0] == '8':
        if queue:
            print(queue[-1])
        else:
            print(-1)