import sys
input = sys.stdin.readline

hsh = '0abcdefghijklmnopqrstuvwxyz'
l = int(input())
line = input().rstrip()
res = 0

for i in range(l):
    res += hsh.index(line[i]) * (31 ** i)

print(res%1234567891)