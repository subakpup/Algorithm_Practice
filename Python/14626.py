import sys
input = sys.stdin.readline

isbn = input().rstrip()

weight = [1 if i % 2 == 0 else 3 for i in range(12)]
damaged = isbn.index('*')
total = 0

for i in range(12):
    if i == damaged:
        continue
    total += int(isbn[i]) * weight[i]
    
for j in range(10):
    tmp = j * weight[damaged] + total
    m = int(isbn[-1])
    if (tmp + m) % 10 == 0:
        print(j)
        break