import sys
input = sys.stdin.readline

if __name__ == '__main__':
    # 지구를 E, 태양을 S, 달을 M
    # (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
    e,s,m = map(int,input().split())
    y = 1
    while True:
        if (y - e) % 15 == 0 and (y - s) % 28 == 0 and (y - m) % 19 == 0:
            break
        y += 1
    print(y)