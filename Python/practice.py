from bisect import bisect_left, bisect_right

array = [1, 2, 3, 4, 4, 6, 8, 9]
x = 0

print(bisect_left(array, x)) # 3
print(bisect_right(array, x)) # 5