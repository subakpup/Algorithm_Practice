import sys
input = sys.stdin.readline

for _ in range(int(input())):
    y,k = zip(*[map(int,input().split()) for _ in range(9)])
    print('Yonsei' if sum(y) > sum(k) else 'Korea' if sum(y) < sum(k) else 'Draw')