import sys
input = sys.stdin.readline

cnt = 0
# for _ in range(int(input())):
#     a = input()
#     if list(a) == sorted(a, key=a.find):
#         cnt += 1
a = input().rstrip()
print(list(a))
print(sorted(a, key=a.find))
print(sorted(a))
# print(cnt)