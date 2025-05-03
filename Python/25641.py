from collections import deque
import sys
input = sys.stdin.readline

def func(n,s):
    for i in range(n):
        if s.count('s') == s.count('t'):
            return print(''.join(s))
        s.popleft()

if __name__ == "__main__":
    n = int(input())
    s = deque(map(str,input().rstrip()))
    func(n,s)