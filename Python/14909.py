# n = list(map(int,input().split()))
# res = 0
# for i in n:
#     if i > 0:
#         res += 1
# print(res)

print(sum(1 for i in map(int,input().split()) if i > 0 ))