import sys
input = sys.stdin.readline

dic = dict()
for i in range(int(input())):
    name,stat = input().split()
    if stat == 'enter':
        dic[name] = stat
    elif stat == 'leave':
        del dic[name]
dic = sorted(dic.keys(), reverse=True)
print('\n'.join(dic))