import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(n, m, x, y):
    done = []
    for sx, sy in zip(x, y):
        done.append(sx + sy)
    done.sort()
    nxt = 0
    cnt = [0 for _ in range(n)]
    cnt[0] = 1
    for i in range(1, n):
        if done[i] >= (done[nxt] + m):
            cnt[i] = 1
            nxt = i
    ans = sum(cnt)
    print(ans)


while True:
    try:
        n, m = map(int, input().strip().split())
        x = [0 for _ in range(n)]
        y = [0 for _ in range(n)]
        for i in range(n):
            x[i], y[i] = map(int, input().strip().split())
        solve(n, m, x, y)
    except Exception as e:
        break
