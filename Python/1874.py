import sys
input = sys.stdin.readline

stk = []
res = []
num = 1

for _ in range(int(input())):
    n = int(input())
    
    while num <= n:
        stk.append(num)
        res.append('+')
        num += 1
    
    if n == stk[-1]:
        stk.pop()
        res.append('-')
    else:
        res.clear()
        res.append('NO')
        break

for i in res:
    print(i)
    
# 4 3 6 8 7 5 2 1
# 1 2 3 4 5 6 7 8
# + + + + - - + + - + + - - - - -
# 4 3 6 8 7 5 2 1