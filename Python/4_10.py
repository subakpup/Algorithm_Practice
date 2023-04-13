import sys
input = sys.stdin.readline

n = int(input())
score_list = list(map(int,input().split()))
arr = []

for score in score_list:
    arr.append(score/max(score_list)*100)

avg = sum(arr)/n

print(avg)