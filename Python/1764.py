# import sys
# input = sys.stdin.readline

# n,m = map(int,input().split())  # 듣도 못한 사람 n, 보도 못한 사람 m
# a = set()
# b = set()

# for _ in range(n):
#     a.add(input())              # 듣도 못한 사람 이름 추가

# for _ in range(m):
#     b.add(input())              # 보도 못한 사람 이름 추가

# result = sorted(a&b)            # a와 b의 교집합(듣보잡)을 정렬!

# print(len(result))              # 듣보잡 수

# for i in result:
#     print(i, end="")            # 한 줄에 한 명씩 출력

import sys
input = sys.stdin.readline

n,m = map(int,input().split())
a = set()
b = set()

for i in range(n):
    a.add(input().strip())
for i in range(m):
    b.add(input().strip())

res = sorted(a&b)
print(len(res))

for i in res:
    print(i)