import sys
input = sys.stdin.readline

while True:
    arr = []
    s = int(input())
    if s == -1:
        break
    for i in range(1, s):
        if s%i == 0:
            arr.append(i)
    if sum(arr) == s:
        print(f'{s} = ', end='')
        print(*arr, sep=' + ')
    else:
        print(f'{s} is NOT perfect.')
