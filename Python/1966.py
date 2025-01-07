from collections import deque
import sys
input = sys.stdin.readline

for _ in range(int(input())):
    n,m = map(int,input().split())
    queue = deque(map(int,input().split()))
    cnt = 0

    while queue:
        output = max(queue)
        first = queue.popleft()
        m -= 1

        if output == first:
            cnt += 1
            if m < 0:
                print(cnt)
                break
        else:
            queue.append(first)
            if m < 0:
                m = len(queue) - 1