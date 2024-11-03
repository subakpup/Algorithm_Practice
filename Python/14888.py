import sys
input = sys.stdin.readline

def dfs(temp):
    global mx,mn
    if oper[0] != 0:
        oper[0] -= 1
        

if __name__ == '__main__':
    n = int(input())
    arr = list(map(int,input().split()))
    # 덧셈, 뺄셈, 곱셈, 나눗셈
    oper = list(map(int,input().split()))

    mx = 1e9
    mn = -1e9

