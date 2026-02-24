import sys
input = sys.stdin.readline

n = int(input())
pw = [input().rstrip() for _ in range(n)]

for i in range(n):
    for j in range(i, n):
        if pw[i][::-1] == pw[j]:
            print(len(pw[i]), pw[i][len(pw[i])//2])
            exit()