import math
import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(x, y):
    z = 1
    while 26 ** y * 10 ** z < x:
        z += 1
    print(z)


for line in sys.stdin:
    x, y = map(int, line.strip().split())
    solve(x, y)
