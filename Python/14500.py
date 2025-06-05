from collections import deque
import sys
input = sys.stdin.readline

def block1(graph):
    area = 0
    for i in range(n):
        for j in range(m-3):
            area = max(area, sum(graph[i][j:j+4]))
    
    for i in range(n-3):
        for j in range(m):
            area = max(area, graph[i][j] + graph[i+1][j] + graph[i+2][j] + graph[i+3][j])
    
    return area

def block2(graph):
    area = 0
    for i in range(n-1):
        for j in range(m-1):
            area = max(area, sum(graph[i][j:j+2]) + sum(graph[i+1][j:j+2]))
    return area

def block3(graph):
    n = len(graph)
    m = len(graph[0])
    area = 0
    for i in range(n-2):
        for j in range(m-1):
            area = max(area, graph[i][j] + graph[i+1][j] + graph[i+2][j] + graph[i+2][j+1], graph[i][j+1] + graph[i+1][j+1] + graph[i+2][j+1] + graph[i+2][j])
    return area

def block4(graph):
    n = len(graph)
    m = len(graph[0])
    area = 0
    for i in range(n-2):
        for j in range(m-1):
            area = max(area, graph[i][j] + graph[i+1][j] + graph[i+1][j+1] + graph[i+2][j+1], graph[i][j+1] + graph[i+1][j+1] + graph[i+1][j] + graph[i+2][j])
    return area

def block5(graph):
    n = len(graph)
    m = len(graph[0])
    area = 0
    for i in range(n-1):
        for j in range(m-2):
            area = max(area, sum(graph[i][j:j+3]) + graph[i+1][j+1])
    return area

if __name__ == "__main__":
    n,m = map(int,input().split())
    board = [list(map(int,input().split())) for _ in range(n)]
    answer = max(block1(board), block2(board), block3(board), block4(board), block5(board))
    board = list(map(list, zip(*board[::-1])))
    print(board)
    # for i in range(3):
    #     board = list(map(list, zip(*board[::-1])))
    #     answer = max(answer, block3(board), block4(board), block5(board))
    
    # print(answer)