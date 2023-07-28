import sys
input = sys.stdin.readline

p,k = map(int,input().split())

for i in range(2,k):
    if p%i == 0:
        print('BAD', i)
        break
else:
    print('GOOD')
'''
p와 q의 곱 pq가 비밀키
p,q 중 하나라도 k보다 작은 암호는 좋지 않은 암호
두 소수의 곱으로 이루어진 암호(P)와 K가 주어졌을 때
좋은 암호인지 구하는 프로그램
'''