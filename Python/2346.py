from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
queue = deque(enumerate(map(int,input().split())))

for i in range(n):
    a = queue.popleft()
    print(a[0]+1, end=' ')
    if a[1] > 0:
        queue.rotate(-(a[1]-1))
    else:
        queue.rotate(-a[1])