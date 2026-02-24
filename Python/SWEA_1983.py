grade = ['A+','A0','A-','B+','B0','B-','C+','C0','C-','D0']
t = int(input())
for test_case in range(1, t+1):
    n,k = map(int,input().split())
    score = []
    for _ in range(n):
        a,b,c = map(int,input().split())
        score.append((a*0.35) + (b*0.45) + (c*0.2))
    target = score[k - 1]
    score.sort(reverse=True)
    s = n // 10
    res = grade[score.index(target) // s]
    print(f'#{test_case} {res}')