import sys
input = sys.stdin.readline

def preoder(node):
    if node == '.':
        return ''
    left, right = tree[node]
    return node + preoder(left) + preoder(right)

def inorder(node):
    if node == '.':
        return ''
    left, right = tree[node]
    return inorder(left) + node + inorder(right)

def postorder(node):
    if node == '.':
        return ''
    left, right = tree[node]
    return postorder(left) + postorder(right) + node
    
if __name__ == "__main__":
    n = int(input())
    tree = dict()
    for _ in range(n):
        root, left, right = input().split()
        tree[root] = (left, right)
        
    print(preoder('A'))
    print(inorder('A'))
    print(postorder('A'))