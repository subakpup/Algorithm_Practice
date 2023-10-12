import sys
input = sys.stdin.readline

now = 1
stack, result, flag = [], [], True
for i in range(int(input())):
    n = int(input())
    # push
    while now <= n:
        stack.append(now)
        result.append('+')
        now += 1
    # pop
    if stack[-1] == n:
        stack.pop()
        result.append('-')
    else:
        flag = False

if flag == False:
    print('NO')
else:
    for i in result:
        print(i)