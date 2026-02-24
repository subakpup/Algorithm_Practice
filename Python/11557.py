import sys
input = sys.stdin.readline

for _ in range(int(input())):
    mx = 0
    mx_name = ""
    for i in range(int(input())):
        s,l = input().split()
        l = int(l)
        if mx < l:
            mx = l
            mx_name = s
    print(mx_name)