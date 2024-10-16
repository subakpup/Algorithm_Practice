import sys
input = sys.stdin.readline

arr = set()
cnt = 0
for i in range(int(input())):
    s = input().strip()
    if s == 'ENTER':
        arr = set()
    elif s in arr:
        continue
    else:
        arr.add(s)
        cnt += 1
print(cnt)