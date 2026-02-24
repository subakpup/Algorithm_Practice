"""Main_2042 구간 합 구하기 (골드 1)
 - 메모리: 162788KB
 - 시간: 640ms

# 문제 정리
 - N개의 수
 - M번 수 변경
 - K번 구간 합 출력
 - K번 b부터 c번째 수까지의 합 출력

# 아이디어
 - 세그먼트 트리 기본 문제
 - 세그먼트 트리를 생성 후
  - 주어진 인덱스의 값을 바꾸는 함수
   - 바꾼 후 세그먼트 트리 업데이트
  - 주어진 구간의 합을 구하는 함수
   - 기저 조건만 잘 설정하면 될 거 같다 !
"""

import sys
input = sys.stdin.readline

# 트리 생성
def tree_build(left, right, node):
    if left == right: # 리프 노드라면
        seg[node] = num[left] # num값 추가
        return seg[node]

    mid = (left + right) // 2
    left_v = tree_build(left, mid, node * 2) # 왼쪽 자식 노드 생성
    right_v = tree_build(mid + 1, right, node * 2 + 1) # 오른쪽 자식 노드 생성
    seg[node] = left_v + right_v # 루트 노드 업데이트
    return seg[node]

# start ~ end 구간 찾기
def find(left, right, node, start, end):
    # 구하려는 범위(start~end)가 트리 구간에 포함되지 않을 경우
    if start > right or end < left:
        return 0
    
    # 구하려는 범위가 현재 트리에 포함
    if start <= left and right <= end:
        return seg[node]
    
    mid = (left + right) // 2
    left_v = find(left, mid, node * 2, start, end) # 왼쪽 자식 노드 합
    right_v = find(mid + 1, right, node * 2 + 1, start, end) # 오른쪽 자식 노드 합
    return left_v + right_v # 현재 노드 값 리턴

# 배열의 idx 값 바꾼 후 세그먼트 트리 갱신
def update(left, right, node, idx, val):
    # 기저조건: 단일 노드이면서 idx와 일치한다면
    if left == right == idx:
        seg[node] = val # 값 업데이트
        return
    
    # idx가 트리 안에 포함되지 않는다면 return
    if idx < left or right < idx:
        return
    
    mid = (left + right) // 2
    update(left, mid, node * 2, idx, val) # 왼쪽 노드 업데이트
    update(mid + 1, right, node * 2 + 1, idx, val) # 오른쪽 노드 업데이트
    seg[node] = seg[node * 2] + seg[node * 2 + 1] # 현재 노드 업데이트

if __name__ == "__main__":
    n,m,k = map(int, input().split())
    num = [0] + [int(input()) for _ in range(n)]
    
    seg = [0 for _ in range(4*n)] # 세그먼트 트리 선언
    tree_build(1, n, 1) # 세그먼트 트리 생성
    
    for i in range(m + k):
        a, b, c = map(int, input().split())

        if a == 1: # b위치 값을 c로 변경
            update(1, n, 1, b, c)
        elif a == 2: # b부터 c까지의 합 출력
            print(find(1, n, 1, b, c))
