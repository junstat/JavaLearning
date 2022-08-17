import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(nums, n):
    nums.sort(key=lambda x: x[1], reverse=True)
    f = [0] * (n + 1)
    s = 0
    e = 0
    for i, j, m in nums:
        e = max(i, e)
        s = min(j, s)
        f[j] += ((m + f[i]) // 100) * 15
    print(f'{s} {f[s]}')


while True:
    try:
        n = int(input().strip())
        nums = [list(map(int, input().strip().split())) for _ in range(n)]
        solve(nums, n)
    except Exception as e:
        break
