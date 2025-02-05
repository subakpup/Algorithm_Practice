from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
arr = deque(list(map(int,input().split())))
c = 0

while True:
    if len(set(arr)) <= 2:
        break
    
    if c == 0:
        arr.popleft()
        c = 1
    else:
        arr.pop()
        c = 0

print(len(arr))