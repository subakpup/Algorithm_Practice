import sys
input = sys.stdin.readline

n = int(input())
arr = {}
cnt = 0

for i in range(n):
    chat = input().rstrip()
    if chat == "ENTER":
        for key, value in arr.items():
            cnt += value
        arr = {}
    else:
        arr[chat] = 1

for key, value in arr.items():
    cnt += value

print(cnt)