import sys
input = sys.stdin.readline

def star(n):
    s = '***\n* *\n***' * n
    return s

print(star(2))