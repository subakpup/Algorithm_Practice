import sys
input = sys.stdin.readline

n,m = map(int,input().split())
arr = set(input().rstrip() for _ in range(n))
brr = set(input().rstrip() for _ in range(m))

res = sorted(list(arr&brr))
print(len(res))
print('\n'.join(res))