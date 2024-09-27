for _ in range(int(input())):
    n = input().split()
    res = float(n[0])
    for i in range(1, len(n)):
        if n[i] == "@":
            res *= 3
        elif n[i] == "%":
            res += 5
        elif n[i] == "#":
            res -= 7
    print("%.2f" % res)