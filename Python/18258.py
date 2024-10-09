from collections import deque
import sys
input = sys.stdin.readline

queue = deque()
for i in range(int(input())):
    a = input().split()
    if a[0] == 'push':
        queue.append(a[1])
    elif a[0] == 'pop':
        print(queue.popleft() if queue else -1)
    elif a[0] == 'size':
        print(len(queue))
    elif a[0] == 'empty':
        print(1 if not queue else 0)
    elif a[0] == 'front':
        print(queue[0] if queue else -1)
    elif a[0] == 'back':
        print(queue[-1] if queue else -1)