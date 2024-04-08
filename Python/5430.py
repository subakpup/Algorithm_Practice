from collections import deque
import sys
input = sys.stdin.readline

<<<<<<< HEAD
for _ in range(int(input())):
    p = input()
    n = int(input())
    x = deque(input().rstrip().replace(',','').replace('[','').replace(']',''))

    for i in p:
        if i == "R":
            x.reverse()
        elif i == "D":
            if x:
                x.popleft()
            else:
                print("error")
print(list(x))
=======
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
>>>>>>> 0a60c5d977e6abab282d91023629e47b5ebc73be
