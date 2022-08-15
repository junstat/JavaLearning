import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def dfs(si, sj, cache, g, end_):
    if (si, sj) in cache:
        return False
    cache.append((si, sj))
    # 控制地图边界
    if not (0 <= si < m and 0 <= sj < n):
        return False
    # 遇到障碍物
    if g[si][sj] == '1':
        return False
    if (si, sj) == tuple(end_):
        return True

    # 有四种情况可以向上下左右走
    return dfs(si + 1, sj, cache, g, end_) or dfs(si - 1, sj, cache, g, end_) or \
           dfs(si, sj + 1, cache, g, end_) or dfs(si, sj - 1, cache, g, end_)


def solve(m, n, g):
    start_points = []
    end_points = []
    for i in range(m):
        for j in range(n):
            if g[i][j] == '2':
                start_points.append((i, j))
            elif g[i][j] == '3':
                end_points.append((i, j))
    ans = 0
    for end_ in end_points:
        # 已达到的坐标，避免重复计算
        cache_a = []
        cache_b = []
        if dfs(start_points[0][0], start_points[0][1], cache_a, g, end_) and \
                dfs(start_points[1][0], start_points[1][1], cache_b, g, end_):
            ans += 1
    print(ans)


while True:
    try:
        m, n = map(int, input().strip().split())
        g = [input().strip().split() for _ in range(m)]
        solve(m, n, g)
    except Exception as e:
        break
