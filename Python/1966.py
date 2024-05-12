from collections import deque
import sys
input = sys.stdin.readline

for i in range(int(input())):
    n,m = map(int,input().split())
    queue = deque(map(int,input().split()))
    res = 0
    
    while queue:
        best = max(queue)
        front = queue.popleft()
        m -= 1

        if best == front:
            res += 1
            if m < 0:
                print(res)
                break
        else:
            queue.append(front)
            if m < 0:
                m = len(queue) - 1