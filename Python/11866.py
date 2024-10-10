from collections import deque
import sys
input = sys.stdin.readline

n,k = map(int,input().split())
queue = deque(range(1, n+1))
res = deque()

while queue:
    for i in range(k):
        queue.append(queue.popleft())
    res.append(queue.pop())

print(f"<{', '.join(map(str, res))}>")