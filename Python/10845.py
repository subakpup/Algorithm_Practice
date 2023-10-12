import sys
input = sys.stdin.readline
queue = []

def push(a):
    queue.append(a)

def pop():
    if queue:
        print(queue.pop(0))
    else:
        print(-1)

def size():
    print(len(queue))

def empty():
    if not queue:
        print(1)
    else:
        print(0)

def front():
    if queue:
        print(queue[0])
    else:
        print(-1)

def back():
    if queue:
        print(queue[-1])
    else:
        print(-1)

if __name__ == "__main__":
    for i in range(int(input())):
        a = input().split()
        if a[0] == 'push':
            push(a[1])
        elif a[0] == 'pop':
            pop()
        elif a[0] == 'size':
            size()
        elif a[0] == 'empty':
            empty()
        elif a[0] == 'front':
            front()
        elif a[0] == 'back':
            back()