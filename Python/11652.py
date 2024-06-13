import sys
input = sys.stdin.readline

arr = {}
for _ in range(int(input())):
    a = int(input())
    if a not in arr:
        arr[a] = 1
    else:
        arr[a] += 1

arr = sorted(arr.items(), key= lambda x: (-x[1], x[0]))
print(arr[0][0])

# 시간 초과 발생
# res=[]
# for key, value in arr.items():
#     if value == max(arr.values()):
#         res.append(key)
# res.sort()
# print(res[0])