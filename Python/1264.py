while True:
    word = input().lower()
    if word == '#':
        break
    print(word.count('a')+word.count('e')+word.count('i')+word.count('o')+word.count('u'))