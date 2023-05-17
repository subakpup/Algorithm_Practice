import sys
input = sys.stdin.readline
con = 0
n = int(input())
for i in range(n):
    con += int(input())
print(con-n+1)