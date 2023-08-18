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

# class Book:

#     def setData(self, title, price, author):
#         self.title = title
#         self.price = price
#         self.author = author

#     def printData(self):
#         print('제목 : ', self.title)
#         print('가격 : ', self.price)
#         print('저자 : ', self.author)

#     def __init__(self):
#         print('책 객체를 새로 만들었어요~')

################################################3
class House:
    def __init__(self, location, house_type, deal_type, price, completion_year):
        self.location = location
        self.house_type = house_type
        self.deal_type = deal_type
        self.price = price
        self.completion_year = completion_year

    def show_detail(self):
        print(self.location, self.house_type, self.deal_type, self.price, self.completion_year)


houses = []
house1 = House('강남','아파트','매매','10억','2010년')
house2 = House('마포','오피스텔','전세','5억','2007년')
house3 = House('송파','빌라','월세','500/50','2000년')

houses.append(house1)
houses.append(house2)
houses.append(house3)

print(f'총 {len(houses)}의 매물이 있습니다.')

for house in houses:
    house.show_detail()