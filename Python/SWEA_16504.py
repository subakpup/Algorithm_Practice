"""
# 문제 정리
 - 방의 길이는 세로 100
  - 즉, 상자는 0부터 100까지 쌓을 수 있음
 - 방을 90도로 회전했을 때, 가장 낙차가 큰 값 출력

# 아이디어
 - 상자의 높이를 담은 배열을 순회하며, 본인보다 작은 값이면 거리 + 1
"""
import sys
input = sys.stdin.readline

if __name__ == "__main__":
    for tc in range(1, int(input())+1): # 테스트 케이스
        n = int(input()) # 가로 길이
        board = list(map(int, input().split())) # 상자 높이

        fall = 0 # 결과(가장 큰 낙차)

        for i in range(n): # 가로 길이만큼 반복
            dis = 0 # 거리를 담을 변수
            for j in range(i+1, n): # 현재 상자와 다음 상자들 비교
                if board[i] > board[j]: # 비교하려는 상자가 본인보다 작다면
                    dis += 1 # 거리 + 1
            fall = max(fall, dis) # 최댓값 업데이트

        print(f'#{tc} {fall}') # 출력