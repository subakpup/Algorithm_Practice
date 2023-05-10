score = []
for i in range(5):
    score.append(int(input()))
    if score[i] < 40:
        score[i] = 40
print(sum(score)//5)