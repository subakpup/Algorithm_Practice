from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
queue = deque(enumerate(map(int,input().split()), start=1))

while queue:
    idx = queue.popleft()
    print(idx[0], end = ' ')

    if idx[1] > 0:
        queue.rotate(-(idx[1]-1))
    else:
        queue.rotate(-idx[1])