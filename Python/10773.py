import sys
input = sys.stdin.readline

stk = []                        # 스택 생성

for i in range(int(input())):
    a = int(input())
    if a == 0:                  # a가 0이면 pop
        stk.pop()
    else:
        stk.append(a)           # 아니라면 stk에 추가

print(sum(stk))