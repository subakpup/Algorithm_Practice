import sys
input = sys.stdin.readline

arr = [input().rstrip() for _ in range(3)]

for i in range(3):
    if arr[i].isdigit():
        res = int(arr[i]) + 3 - i

if res % 15 == 0:
    print("FizzBuzz")
elif res % 3 == 0:
    print("Fizz")
elif res % 5 == 0:
    print("Buzz")
else:
    print(res)