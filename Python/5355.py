import sys
input = sys.stdin.readline

for i in range(int(input())):
    a = list(map(str,input().split()))
    res = 0
    for j in range(len(a)):
        if j == 0:
            res += float(a[j])
        else:
            if a[j] == "@":
                res *= 3
            elif a[j] == "%":
                res += 5
            elif a[j] == "#":
                res -= 7
    print(f"{res:.2f}")