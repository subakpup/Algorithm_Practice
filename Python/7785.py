import sys
input = sys.stdin.readline

s = set()                           # 비어있는 set 생성
for _ in range(int(input())):       # 출입 기록의 수
    a,b = map(str, input().split()) # 이름, 출퇴근

    if b == "enter":
        s.add(a)                    # enter일 경우 set에 추가
    elif b == "leave":
        s.remove(a)                 # leave일 경우 set에서 삭제

for i in sorted(s, reverse=True):   # s의 역순 정렬
    print(i)