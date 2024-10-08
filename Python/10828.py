import sys
input = sys.stdin.readline

stk = []

def push(x):
    stk.append(x)

def pop():
    if stk:
        print(stk.pop())
    else:
        print(-1)

def size():
    print(len(stk))

def empty():
    if stk:
        print(0)
    else:
        print(1)
    
def top():
    if stk:
        return print(stk[-1])
    else:
        return print(-1)
    
if __name__ == '__main__':
    for i in range(int(input())):
        n = input().split()
        if n[0] == 'push': push(n[1])
        elif n[0] == 'pop': pop()
        elif n[0] == 'size': size()
        elif n[0] == 'empty' : empty()
        elif n[0] == 'top': top()