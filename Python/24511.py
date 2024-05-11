from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int,input().split())) # a[i] == 0: queue, a[i] == 1: stack
b = list(map(int,input().split())) # 원소
m = int(input())
c = list(map(int,input().split())) # 삽입할 원소를 담고 있는 수열

queue = deque()
for i in range(n):
    if a[i] == 0:
        queue.append(b[i])

for j in range(m):
    queue.appendleft(c[j])

for k in range(m):
    print(queue.pop(), end=' ')