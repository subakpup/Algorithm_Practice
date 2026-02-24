arr = []
for _ in range(int(input())):
    n = input()
    arr.append(n[0])

result = []
for i in arr:
    if arr.count(i) >= 5:
        result.append(i)

if len(result) > 0:
    print(''.join(sorted(set(result))))
else:
    print("PREDAJA")