import sys
input = sys.stdin.readline

word = []

for i in range(int(input())):
    word.append(input().rstrip())
word = list(set(word))
word.sort()
word.sort(key=len)

for i in word:
    print(i)