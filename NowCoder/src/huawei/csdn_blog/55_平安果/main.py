import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(nums, m, n):
    f = [[0 for _ in range(n)] for _ in range(n)]
    f[0][0] = nums[0][0]
    for i in range(0, m):
        for j in range(0, n):
            if i == 0 and j == 0:
                f[i][j] = nums[i][j]
            if i == 0 and j != 0:
                f[i][j] = f[i][j - 1] + nums[i][j]
            elif i != 0 and j == 0:
                f[i][j] = f[i - 1][j] + nums[i][j]
            else:
                f[i][j] = max(f[i - 1][j], f[i][j - 1]) + nums[i][j]
    print(f[m - 1][n - 1])


while True:
    try:
        m, n = map(int, input().strip().split())
        nums = [list(map(int, input().strip().split())) for _ in range(m)]
        solve(nums, m, n)
    except Exception as e:
        break
