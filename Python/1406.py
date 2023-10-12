import sys
input = sys.stdin.readline

a = list(input().rstrip())
b = []

for i in range(int(input())):
    z = input().split()
    if z[0] == 'L' and a:
        b.append(a.pop())        
    elif z[0] == 'D' and b:
        a.append(b.pop())
    elif z[0] == 'B' and a:
        a.pop()
    elif z[0] == 'P':
        a.append(z[1])

print(''.join(a+list(reversed(b))))