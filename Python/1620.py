# import sys
# input = sys.stdin.readline

# n,m = map(int,input().split())
# id = {}
# name = {}
# for i in range(1, n+1):
#     pkm = input().rstrip()
#     id[i] = pkm
#     name[pkm] = i

# for j in range(m):
#     ip = input().rstrip()
#     if ip.isdigit():
#         print(id[int(ip)])
#     elif ip.isalpha():
#         print(name[ip])

import sys
input = sys.stdin.readline

n,m = map(int,input().split())
name = {}
number = {}

for i in range(1, n+1):
    a = input().strip()
    name[i] = a
    number[a] = i
    
for j in range(m):
    b = input().strip()
    if b.isdigit():
        print(name[int(b)])
    elif b.isalpha():
        print(number[b])