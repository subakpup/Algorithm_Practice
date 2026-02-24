import sys
input = sys.stdin.readline

def cantor(n):
    if n == 1:
        return '-'
    else:
        side = cantor(n//3)
        center = ' ' * (n//3)
        return side + center + side

while True:
    try:
        n = int(input())
        line = cantor(3**n)
        print(line)
    except:
        break