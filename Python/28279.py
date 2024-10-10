from collections import deque
import sys
input = sys.stdin.readline

queue = deque()

for i in range(int(input())):
    c = list(map(int,input().split()))
    if c[0] == 1:
        queue.appendleft(c[1])
    elif c[0] == 2:
        queue.append(c[1])
    elif c[0] == 3:
        print(queue.popleft() if queue else -1)
    elif c[0] == 4:
        print(queue.pop() if queue else -1)
    elif c[0] == 5:
        print(len(queue))
    elif c[0] == 6:
        print(1 if not queue else 0)
    elif c[0] == 7:
        print(queue[0] if queue else -1)
    elif c[0] == 8:
        print(queue[-1] if queue else -1)