import sys
input = sys.stdin.readline

n = int(input())
res = ""
for i in range(n//4):
    res += "long "
print(res + "int")