import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(names, p):
    ans = []
    for name in names:
        i = 0
        j = 0
        while i < len(name) and j < len(p):
            if name[i] == p[j]:
                i += 1
                j += 1
            else:
                i += 1
        if j != len(p):
            continue
        while i < len(name) and name[i] != ' ':
            i += 1
        if i != len(name):
            continue
        ans.append(name)
    print(",".join(ans))


while True:
    try:
        names = input().strip().split(",")
        pattern = input().strip()
        solve(names, pattern)
    except Exception as e:
        break
