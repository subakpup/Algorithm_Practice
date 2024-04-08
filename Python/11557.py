import sys
input = sys.stdin.readline

for i in range(int(input())):
    max = 0
    name = ""
    for j in range(int(input())):
        s,l = map(str,input().split())
        l = int(l)
        if (l > max):
            max = l
            name = s
    print(name)