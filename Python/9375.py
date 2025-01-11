import sys
input = sys.stdin.readline

for _ in range(int(input())):
    wear = dict()
    for _ in range(int(input())):
        a, b = input().split()
        if b in wear:
            wear[b].append(a)
        else:
            wear[b] = [a]
    cnt = 1
    for i in wear:
        cnt *= len(wear[i]) + 1
    print(cnt -1)