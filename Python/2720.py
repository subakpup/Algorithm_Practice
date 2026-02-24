for i in range(int(input())):
    c = int(input())
    q = c // 25; d = (c % 25) // 10
    n = (c % 25 % 10) // 5; p = c % 25 % 10 % 5
    print(q,d,n,p)

# for _ in range(int(input())):
#     c = int(input())
#     for i in [25, 10, 5, 1]:
#         print(c//i, end=" ")
#         c %= i
#     print()