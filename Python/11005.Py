import sys
input = sys.stdin.readline

n,b = map(int,input().split())
number = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'
result = ''

while n != 0:
    result += str(number[n%b])
    n //= b
print(result[::-1])