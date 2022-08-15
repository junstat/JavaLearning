import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(n):
    if n == 0:
        return "1"
    ans = "1"
    for _ in range(n):
        cur = ""
        m = len(ans)
        j = 0
        while j < m:
            k = j + 1
            while k < m and ans[j] == ans[k]:
                k += 1
            cnt = k - j
            cur += f'{cnt}{ans[j]}'
            j = k
        ans = cur
    return ans


for line in sys.stdin:
    n = int(line.strip())
    print(solve(n))
