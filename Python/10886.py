import sys
input = sys.stdin.readline

a = []

for i in range(int(input())):
    a.append(int(input()))

if a.count(1) > a.count(0):
    print('Junhee is cute!')
else:
    print('Junhee is not cute!')