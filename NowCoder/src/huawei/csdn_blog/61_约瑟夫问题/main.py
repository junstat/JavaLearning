import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(nums, m):
    ans = []
    i = 0
    c = 1
    while nums:
        if i == len(nums):
            i = 0
        if c % m == 0:
            m = nums.pop(i)
            ans.append(m)
            c = 1
        else:
            i += 1
            c += 1
    print(",".join(map(str, ans)))


while True:
    try:
        nums = list(map(int, input().strip().split(",")))
        m = int(input().strip())
        solve(nums, m)
    except Exception as e:
        break
