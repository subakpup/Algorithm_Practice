# import sys
# input = sys.stdin.readline

# for i in range(int(input())):
#     stack = []
#     a = input()
#     for j in a:
#         if j == "(":
#             stack.append(j)
#         elif j == ")":
#             if stack:
#                 stack.pop()
#             else:
#                 print('NO')
#                 break
#     else:
#         if stack:
#             print("NO")
#         else:
#             print("YES")

import sys
input = sys.stdin.readline

for i in range(int(input())):
    stk = []
    ip = input()
    for j in ip:
        if j == "(":
            stk.append(j)
        elif j == ")":
            if stk:
                stk.pop()
            else:
                print("NO")
                break
    else:
        if stk:
            print("NO")
        else:
            print("YES")