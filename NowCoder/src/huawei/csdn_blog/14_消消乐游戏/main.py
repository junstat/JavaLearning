import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(s):
    i = 0
    while i < len(s):
        if s[i] * 2 in s:
            s = s.replace(s[i] * 2, "")
            i = max(0, i - 1)
        else:
            i += 1
    print(len(s))


for line in sys.stdin:
    solve(line.strip())
