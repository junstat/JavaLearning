import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(n, nums, m):
    sums = [0 for _ in range(n + 1)]
    for i in range(1, n + 1):
        sums[i] = sums[i - 1] + nums[i - 1]

    ans = sums[m]
    for i in range(m, n + 1):
        cur = sums[i] - sums[i - m]
        if cur > ans:
            ans = cur
    print(ans)


while True:
    try:
        n = int(input().strip())
        nums = list(map(int, input().strip().split()))
        m = int(input().strip())
        solve(n, nums, m)
    except Exception as e:
        break
