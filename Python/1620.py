import sys
input = sys.stdin.readline

n,m = map(int,input().split())
id = {}
name = {}
for i in range(1, n+1):
    pkm = input().rstrip()
    id[i] = pkm
    name[pkm] = i

for j in range(m):
    ip = input().rstrip()
    if ip.isdigit():
        print(id[int(ip)])
    elif ip.isalpha():
        print(name[ip])

# 시간 초과 ;;
# import sys
# input = sys.stdin.readline

# n,m = map(int,input().split())
# pcm = []
# result = []
# for i in range(n):
#     pcm.append(input().rstrip())
# for j in range(m):
#     name = input().rstrip()
#     if name.isdigit():
#         result.append(pcm[int(name)-1])
#     elif name.isalpha():
#         result.append(pcm.index(name)+1)

# for _ in result:
#     print(_)