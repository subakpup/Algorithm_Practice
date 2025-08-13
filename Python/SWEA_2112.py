""" Solution_2112 보호 필름
# 문제 정리
 - 두께 D, 가로 크기 W의 보호 필름
 - 각 셀들은 특성 A 또는 특성 B를 가지고 있다.
 - 세로방향에 대해서 동일한 특성의 셀들이 K개 이상 연속적으로 있는 경우에만 성능검사를 통과
 - 약품을 투입하면 막의 모든 셀들을 하나의 특성으로 변환시킴
 - 최소 약품 투입 횟수

# 아이디어
 - 가지치기를 잘하면 탐색 시간을 줄일 수 있을 거 같다!
 - k개가 연속으로 이어져 있으면 값 갱신
 - 약품을 투약하지 않았을 경우, A 약품을 투약했을 경우, B 약품을 투약했을 경우 모두 탐색
"""

def dfs(idx, cnt):
    # 현재까지 사용한 약품 횟수가 최소값보다 크면 탐색 종료(가지치기)
    if cnt >= answer:
        return

    # 모든 막을 다 탐색했으면 성능 검사 수행
    if idx == d:
        for i in range(w): # 각 열 검사
            same = 1 # 연속된 동일 특성 개수 초기화
            flag = False # 이 열이 K 이상 연속되는지 여부
            for j in range(d-1):  # 세로 방향 검사
                if film[j][i] == film[j+1][i]:  # 같은 특성이면 + 1
                    same += 1
                else:                            # 다르면 초기화
                    same = 1

                if same >= k:  # K 이상 연속되면 통과
                    flag = True
                    break

            if not flag:  # 한 열이라도 조건 불만족이면 이 경로 실패
                return
            
        # 모든 열이 조건 만족 → 최소 약품 투입 횟수 갱신
        answer = min(answer, cnt)
        return
    
    # 현재 막의 원래 상태 저장
    tmp = film[idx][:]

    # 1. 약품 투입 X
    dfs(idx+1, cnt)
    
    # 2. 특성 A로 변경 후 탐색
    film[idx] = [0] * w
    dfs(idx+1, cnt+1)

    # 3. 특성 B로 변경 후 탐색
    film[idx] = [1] * w
    dfs(idx+1, cnt+1)

    # 원래 막 상태로 복원
    film[idx] = tmp

if __name__ == "__main__":
    for tc in range(1, int(input())+1):
        d, w, k = map(int, input().split()) # 두께 D, 가로 W, 합격기준 K
        film = [list(map(int, input().split())) for _ in range(d)] # 필름 정보 입력
        answer = int(1e9) # 최소 약품 투입 횟수 초기화
        dfs(0,0) # DFS 탐색 시작
        print(f'#{tc} {answer}') # 결과 출력