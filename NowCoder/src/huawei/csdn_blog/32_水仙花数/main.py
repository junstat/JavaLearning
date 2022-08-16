import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def get_sum(s):
    ans = 0
    for c in s:
        ans += ord(c)
    return ans


def check(s):
    num = get_sum(s)
    a = num % 10
    b = num // 10 % 10
    c = num // 100
    return a ** 3 + b ** 3 + c ** 3 == num


def dfs(s, n, u, d, ans):
    if u == n:
        ans.append(d)
        return
    for e in range(u + 1, n + 1):
        s1 = s[u:e]
        if check(s1):
            dfs(s, n, e, d + 1, ans)


def solve(s):
    n = len(s)
    ans = []

    dfs(s, n, 0, 0, ans)
    if not ans:
        print(0)
    elif len(ans) == 1:
        print(ans[0])
    elif len(ans) > 1:
        print(-1)


for line in sys.stdin:
    solve(line.strip())
