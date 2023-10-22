import sys
input = sys.stdin.readline

n,b = input().split()
n = n[::-1]
b = int(b)
number = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'
result = 0
for i in range(len(n)-1, -1, -1):
    sum = (b**i)*number.index(n[i])
    result += sum

print(result)