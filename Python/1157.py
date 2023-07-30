import sys
input = sys.stdin.readline
 
word = str(input()).upper()
word_list = list(set(word))
arr = []

for i in word_list:
    arr.append(word.count(i))

if arr.count(max(arr)) > 1:
    print("?")
else:
    print(word_list[arr.index(max(arr))])