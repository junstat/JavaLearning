import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


class Node(object):

    def __init__(self, _val, _left=None, _right=None):
        self.val = _val
        self.left = _left
        self.right = _right


def dfs(root):
    if root is not None:
        dfs(root.left)
        print(root.val, end="")
        dfs(root.right)


def solve(s):
    i = 1
    len_ = len(s)
    stk = []
    root = Node(s[0])
    temp = root
    stk.append(temp)

    while i < len_:
        if s[i] == '{' and s[i + 1] != ',':  # {b
            i += 1
            stk.append(temp)
            temp.left = Node(s[i])
            temp = temp.left
        elif s[i] == '{' and s[i + 1] == ',':  # h{,I
            i += 2
            stk.append(temp)
            temp.right = Node(s[i])
            temp = temp.right
        elif s[i - 1] != '{' and s[i - 1] != '}' and s[i] == ',':  # g,h
            i += 1
            temp = stk.pop()
            temp.right = Node(s[i])
            temp = temp.right
        elif s[i] == ',':  # },c
            i += 1
            stk.append(temp)
            temp.right = Node(s[i])
            temp = temp.right
        elif s[i] == '}':
            temp = stk.pop()
        i += 1

    dfs(root)


while True:
    try:
        s = input().strip()
        solve(s)
    except Exception as e:
        break
