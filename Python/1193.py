# 1/1
# 2/1 1/2
# 3/1 2/2 1/3
# 1/4 2/3 3/2 4/1
# 5/1 4/2 3/3 2/4 1/5
# 규칙 발생
# 짝수라인: 분자 증가
# 홀수라인: 분모 증가
x = int(input())
line = 1

while x > line:
    x -= line
    line += 1

if line % 2 == 0:
    y = line - x + 1
    print(f'{x}/{y}')
else:
    y = line - x + 1
    print(f'{y}/{x}')