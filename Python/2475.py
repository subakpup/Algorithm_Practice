a = list(map(int,input().split()))
res = 0
for i in range(len(a)):
    res += a[i] ** 2
print(res%10)