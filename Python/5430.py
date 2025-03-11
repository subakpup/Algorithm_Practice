from collections import deque
import sys
input = sys.stdin.readline

def func():
    p = input().rstrip()
    n = int(input())
    x = input().rstrip()
    
    if n == 0:
        arr = deque()
    else:
        arr = deque(map(int,x[1:-1].split(",")))
    
    flag = False
    
    for c in p:
        if c == "R":
            flag = not flag
        elif c == "D":
            if not arr:
                return 'error'
            
            if flag:
                arr.pop()
            else:
                arr.popleft()
                
    if flag:
        arr.reverse()
    
    return f"[{','.join(map(str, arr))}]"
    

if __name__ == "__main__":
    t = int(input())
    for tc in range(t):
        print(func())