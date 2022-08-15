import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in

MAX_V = 1009
INF = 0x3f3f3f3f
g = [[INF for _ in range(MAX_V)] for _ in range(MAX_V)]
visited = [False] * MAX_V
ans = INF
cur = 0


def dfs(s, e):
    global ans, cur
    if s == e:
        ans = min(ans, cur)
    visited[s] = True
    for i in range(1, n + 1):
        if g[s][i] != INF and not visited[i]:
            visited[i] = True
            cur += g[s][i]
            dfs(i, e)
            cur -= g[s][i]
            visited[i] = False


while True:
    try:
        n, m = map(int, input().strip().split())
        for _ in range(m):
            u, v, w = map(int, input().strip().split())
            g[u][v] = w
        s, e = map(int, input().strip().split())
        dfs(s, e)
        print(ans)
    except Exception as e:
        break
