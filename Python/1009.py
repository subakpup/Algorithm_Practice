import sys
input = sys.stdin.readline

t = int(input())

for i in range(t):
    a,b = map(int,input().split())
    a = a % 10

    if a == 0:
        print(10)
    elif a in [1,5,6]:
        print(a)
    elif a in [4,9]:
        b = b%2
        if b == 1:
            print(a)
        else:
            print(a*a%10)
    else:
        b = b%4
        if b == 0:
            print(a**4%10)
        else:
            print(a**b%10)

'''
재용이가 가지고 있는 컴퓨터 10대
1번부터 10번 번호 부여
1번 데이터 - 1번 컴퓨터, 2번 데이터 - 2번 컴퓨터, ***, 10번 컴퓨터, 11번 데이터 - 1번 컴퓨터
마지막 데이터가 처리될 컴퓨터의 번호
'''