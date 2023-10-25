# def MenOfPassion(A,n):
#     answer = 0
#     for i in range(1, n-1):
#         for j in range(i+1, n, -1):
#             answer = answer + A[i] * A[j]
#     return answer

n = int(input())

res = 0
for i in range(1, n):
    res += i
print(res)
print(2)