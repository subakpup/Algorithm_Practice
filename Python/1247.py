import sys
input = sys.stdin.readline

for i in range(3):
    arr = []
    for i in range(int(input())):
        a = int(input())
        arr.append(a)
    if sum(arr) > 0:
        print('+')
    elif sum(arr) == 0:
        print('0')
    elif sum(arr) < 0:
        print('-')