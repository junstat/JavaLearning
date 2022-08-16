import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(n, m, nums, k):
    q = [0 if i + 1 in nums else 1 for i in range(n)]
    max_ = 0
    # 双指针
    i = 0
    j = min(k, n)
    while j <= n:
        # 求子串中0的个数
        cnt = q[i:j].count(0)
        if cnt < k:
            j += 1
        elif cnt == k:
            max_ = max(j - i, max_)
            j += 1
        else:
            i += 1
    print(max_)


while True:
    try:
        n = int(input().strip())
        m = int(input().strip())
        nums = list(map(int, input().strip().split()))
        k = int(input().strip())
        solve(n, m, nums, k)
    except Exception as e:
        break
