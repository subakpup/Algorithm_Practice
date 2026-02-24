# n = int(input())
# name = []

# for i in range(n):
#     name.append(input())
#     result = list(name[i])

# for i in range(n):
#     for j in range(len(result)):
#         if result[j] == name[i][j]:
#             continue
#         else:
#             result[j] = '?'

# print(''.join(result))

n = int(input())
a = list(input())

for i in range(n-1):
    b = list(input())
    for j in range(len(a)):
        if a[j] != b[j]:
            a[j] = '?'
print(''.join(a))