import sys
input = sys.stdin.readline

k,l = map(int,input().split())

for i in range(2,l):
    if k%i == 0:
        print("BAD", i)
        break
else:
    print("GOOD")
'''
k,l 주어짐
k를 인수분해 했을 때 항상 l 이상의 값으로만 이루어져 있는지
확인하려고 함

'''