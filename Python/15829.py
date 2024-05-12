import sys
input = sys.stdin.readline

l = int(input())
a = input()

res = 0

for i in range(l):
    res += (ord(a[i])-96)*(31**i)
print(res % 1234567891)