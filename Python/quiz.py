# from random import *

# result = []

# for i in range(1, 51):
#     time = randint(5,50)
#     print(f'{i}번째 손님 (소요시간 : {time}분)')

#     if time > 5 and time < 15:
#         result.append(i)
# print(result)
# print(f'총 탑승 승객 : {len(result)}')

####################################################

# def std(height, gender):
#     if gender == 'man':
#         return height ** 2 * 22
#     elif gender == 'woman':
#         return height ** 2 * 21
#     else:
#         print("Error")

# if __name__ == '__main__':
#     height = int(input())
#     gender = input()
#     weight = std(height/100, gender)
#     print(f'키 {height} {gender}의 표준 체중은 {weight:.2f}kg입니다.')

########################################

class Book:

    def setData(self, title, price, author):
        self.title = title
        self.price = price
        self.author = author

    def printData(self):
        print('제목 : ', self.title)
        print('가격 : ', self.price)
        print('저자 : ', self.author)

    def __init__(self):
        print('책 객체를 새로 만들었어요~')