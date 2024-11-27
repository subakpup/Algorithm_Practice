# N 이하의 수 중에서 가장 큰 2의 거듭제곱수를 반환하는 함수
# func을 작성하라. N은 10억 이하의 자연수이다.

def func(n):
    x = 1
    while 2 * x <= n:
        x *= 2
    return x

# func(5) == 4
# func(97615282) == 67108864
# func(1024) = 1024

if __name__ == "__main__":
    print(func(5))
    print(func(97615282))
    print(func(1024))