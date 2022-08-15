import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(n):
    a, b = 0, 1
    for _ in range(n):
        a, b = b, a + b
    print(a)


for line in sys.stdin:
    n = int(line.strip())
    solve(n)
