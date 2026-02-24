"""Solution_1486 장훈이의 높은 선반 (D4)
# 문제 정리
 - 높이가 B인 선반
 - N명읜 점원
 - 각 점원의 키 H[i]
 - 점원들이 탑을 쌓아 선반 위의 물건을 사용
  - 점원은 1명 이상
 - 탑의 높이는 점원의 키 합
 - 탑의 높이가 B 이상일 경우 물건 사용 가능
 > 높이가 B 이상인 가장 낮은 탑

# 아이디어
 - 백트래킹을 이용하면 될 거 같다!
 - 이 점원을 선택하는 경우, 선택하지 않는 경우를 고르면 되겠다
 - 이미 정답을 넘어가는 수는 고려하지 않는다면 최적화 되겠다!!
"""

from collections import deque

def dfs(depth, height):
    global answer

    # 가지치기
    if height >= answer:
        return
    
    # 최대 깊이에 도달하고 현재 키가 B 이상일 때 정답 업데이트
    if depth == n:
        if height >= b:
            answer = min(answer, height)
        return
    
    # 선택한 경우
    dfs(depth + 1, height)

    # 선택하지 않는 경우
    dfs(depth + 1, height + h[depth])

if __name__ == "__main__":
    t = int(input())
    for tc in range(1, t+1):
        n,b = map(int,input().split())
        h = list(map(int,input().split()))

        answer = int(1e9) # 정답값 초기화
        dfs(0,0) # 깊이 0, 키 0부터 시작
        answer -= b
        print(f'#{tc} {answer}')
