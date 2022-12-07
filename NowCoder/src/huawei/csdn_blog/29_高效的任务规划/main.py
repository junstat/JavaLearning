import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(nums, n):
    last = 0
    ans = 0
    f = [0 for _ in range(n)]
    # 按工作时间降序
    nums.sort(key=lambda x: -x[1])
    for i in range(n):
        f[i] = last + nums[i][0] + nums[i][1]
        last += nums[i][0]
        ans = max(ans, f[i])
    print(ans)


while True:
    try:
        m = int(input().strip())
        for _ in range(m):
            n = int(input().strip())
            machine = [[0 for _ in range(2)] for _ in range(n)]  # n x 2
            for i in range(n):
                B, J = map(int, input().strip().split())
                machine[i][0] = B
                machine[i][1] = J
            solve(machine, n)
    except Exception as e:
        break
