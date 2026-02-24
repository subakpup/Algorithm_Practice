for i in range(int(input())):
    w = input()
    wl = ''
    for j in w:
        if wl != j:
            print(j, end="")
            wl = j
    print()