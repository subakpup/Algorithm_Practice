import sys
input = sys.stdin.readline

def func():
    i = 0 # s 인덱스
    ioi = 0 # IOI 개수
    cnt = 0 # 패턴 카운트

    while i < m-1:
        if s[i:i+3] == "IOI":
            ioi += 1
            if ioi >= n:
                cnt += 1
            i += 2 # IOI의 3번째 I부터 다시 검사 시작
        else:
            ioi = 0
            i += 1
    
    return cnt

if __name__ == "__main__":
    n = int(input())
    m = int(input())
    s = input().rstrip()
    print(func())