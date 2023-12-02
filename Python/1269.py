import sys
input = sys.stdin.readline

n,m = map(int,input().split())

a = set(map(int,input().split()))
b = set(map(int,input().split()))
print(len(a-b)+len(b-a))

# 시간 초과 ;;
# import sys
# input = sys.stdin.readline

# ast,bst = map(int,input().split())

# a = list(map(int,input().split()))
# b = list(map(int,input().split()))

# a_b = [i for i in a if i not in b]
# b_a = [j for j in b if j not in a]

# print(len(a_b)+len(b_a))