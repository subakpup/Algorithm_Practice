from collections import deque
import sys
input = sys.stdin.readline

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