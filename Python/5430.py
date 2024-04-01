from collections import deque
import sys
input = sys.stdin.readline

for i in range(int(input())):
    p = input().strip()
    n = int(input())
    arr = deque(input().strip()[1:-1].split(','))
    
    if n == 0:
        arr = []
    flag = 0
    
    for i in p:
        if i == "R":
            flag += 1
        elif i == "D":
            if arr:
                if flag % 2 == 0:
                    arr.popleft()
                else:
                    arr.pop()
            else:
                print("error")
                break
    else:
        if flag % 2 == 1:
            arr.reverse()
        print('['+','.join(arr)+']')