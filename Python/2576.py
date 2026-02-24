arr = []
for i in range(7):
    n = int(input())
    if n % 2 == 1:
        arr.append(n)
if not arr:
    print(-1)
else:
    print(sum(arr))
    print(min(arr))