try:
    while True:
        name = input()
        for i in name:
            if i == 'e':
                print('i', end='')
            elif i == 'E':
                print('I', end='')
            elif i == 'i':
                print("e", end='')
            elif i == 'I':
                print('E', end='')
            else:
                print(i, end='')
        print()
except:
    exit(0)