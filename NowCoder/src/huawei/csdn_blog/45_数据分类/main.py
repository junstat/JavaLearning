import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(c, b, nums):
    ans = dict()
    for n in nums:
        n_hex = hex(n)[2:].zfill(8)
        byte_sum = 0
        for i in range(0, len(n_hex), 2):
            byte_sum += int(n_hex[i: i + 2], 16)

        m = byte_sum % b
        if m < c:
            ans.setdefault(m, 0)
            ans[m] += 1
    if ans:
        print(max(ans.values()))
    else:
        print(0)


while True:
    try:
        c, b, *nums = list(map(int, input().strip().split()))
        solve(c, b, nums)
    except Exception as e:
        break
