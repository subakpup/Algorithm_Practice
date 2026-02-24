import sys
input = sys.stdin.readline

arr = sorted(int(input()) for _ in range(int(input())))
print(round(sum(arr)/len(arr)))
print(arr[len(arr)//2])

dic = dict()
for i in arr:
    if i in dic:
        dic[i] += 1
    else:
        dic[i] = 1
mx = []
for j in dic:
    if max(dic.values()) == dic[j]:
        mx.append(j)

if len(mx) > 1:
    print(mx[1])
else:
    print(*mx)

print(max(arr)-min(arr))