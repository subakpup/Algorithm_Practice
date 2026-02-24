n = input()
arr = sorted(int(i) for i in n)
print(*arr[::-1], sep='')