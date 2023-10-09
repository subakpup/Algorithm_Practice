import sys
input = sys.stdin.readline

def push(a):
    stack.append(a)

def pop():
    if len(stack) != 0:
        print(stack.pop())
    else:
        print(-1)

def size():
    print(len(stack))

def empty():
    if len(stack) == 0:
        print(1)
    else:
        print(0)

def top():
    if len(stack) != 0:
        print(stack[-1])
    else:
        print(-1)

if __name__ == "__main__":
    stack = []
    for i in range(int(input())):
        cmd = input().split()
        if cmd[0] == 'push':
            push(cmd[1])
        elif cmd[0] == 'pop':
            pop()
        elif cmd[0] == 'size':
            size()
        elif cmd[0] == 'empty':
            empty()
        elif cmd[0] == 'top':
            top()