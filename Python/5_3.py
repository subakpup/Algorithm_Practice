import sys
input = sys.stdin.readline

t = int(input())

for i in range(t):
    words = str(input())
    print(words.strip()[0],words.strip()[-1],sep ='')