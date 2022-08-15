import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(s, m, n):
    l = 0 if m < 0 else m
    r = len(s) - 1 if n >= len(s) else n

    s0 = s[:l]
    s1 = s[l: r + 1]
    s2 = s[r + 1:]
    print(" ".join(s0 + s1[::-1] + s2))


while True:
    try:
        s = input().strip().split()
        m, n = map(int, input().strip().split())
        solve(s, m, n)
    except Exception as e:
        break
