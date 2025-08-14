"""Solution_1952 수영장 (D4)
# 문제 정리
 - 이용권
  1. 1일권
  2. 1달권: 매달 1일 시작
  3. 3달권: 매달 1일 시작(당해에만 사용 가능)
  4. 1년권: 매년 1월 1일 시작
 - 1년 동안의 수영장 이용 계획이 주어짐
 - 1년 동안의 최소 비용을 구하는 문제

# 아이디어
 - DFS를 이용하여 모든 경우의 수를 탐색
 - 각 달마다 1일권, 1달권, 3달권, 1년권을 선택할 수 있음
"""

def dfs(month, cost):
    global answer
    
    # 12월에 도달한 경우 최솟값 계산
    if month >= 12:
        answer = min(answer, cost)
        return
    
    if plan[month] > 0:
        # 1일권
        dfs(month + 1, cost + price[0] * plan[month])
    
        # 1달권
        dfs(month + 1, cost + price[1])

        # 3달권
        dfs(month + 3, cost + price[2])
    else:
        # 당월에 계획이 없을 경우
        dfs(month + 1, cost)


if __name__ == "__main__":
    t = int(input())
    for tc in range(1, t+1):
        price = list(map(int, input().split()))
        plan = list(map(int,input().split()))
        
        answer = int(1e9) # 정답
        dfs(0,0) # 1월, 0원부터 시작
        answer = min(answer, price[3])
        print(f'#{tc} {answer}')
