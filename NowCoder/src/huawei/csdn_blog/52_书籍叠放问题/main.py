import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(nums, n):
    check = lambda x, a, b: x[a][0] < x[b][0] and x[a][1] < x[b][1]
    nums.sort(key=lambda x: x[0])
    n = len(nums)
    f = [0 for _ in range(n)]
    ans = 1
    for i in range(n):
        f[i] = 1
        for j in range(i - 1, -1, -1):
            if check(nums, j, i):
                f[i] = max(f[i], f[j] + 1)
        ans = max(ans, f[i])
    print(ans)


while True:
    try:
        n = int(input().strip())
        nums = []
        for _ in range(n):
            nums.append(list(map(int, input().strip().split())))
        solve(nums, n)
    except Exception as e:
        break
