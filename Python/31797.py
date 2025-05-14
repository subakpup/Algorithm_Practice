from collections import deque
import sys
input = sys.stdin.readline

n,m = map(int,input().split())
queue= deque()

for i in range(1,m+1):
    a,b = map(int,input().split())
    queue.append([a,i])
    queue.append([b,i])
    
queue = deque(sorted(queue))

for _ in range(n):
    queue.rotate(-1)

print(queue[-1][1])