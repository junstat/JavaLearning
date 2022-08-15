import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(s):
    s = s.replace(" ", "")
    parts = s.split("1")
    print(max([len(x) for x in parts]) - 1)


for line in sys.stdin:
    solve(line.strip())
