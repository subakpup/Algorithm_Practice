# import sys
# input = sys.stdin.readline

# for _ in range(int(input())):
#     a,b = map(int,input().split())
    
#     for i in range(max(a,b), (a*b)+1):
#         if i%a == 0 and i%b == 0:
#             print(i)
#             break

import sys
input = sys.stdin.readline

for i in range(int(input())):
    a,b = map(int,input().split())
    x,y = a,b
    
    while a%b != 0:
        a,b = b,a%b
    print(x*y//b)