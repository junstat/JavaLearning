import sys
from functools import cmp_to_key

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def cmp(a, b):
    if a[0] == b[0]:
        return a[1] - b[1]
    return a[0] - b[0]


def solve(nums):
    q = []
    # 1. 对于每一个面试[s, e]，把s理解成上(up)公交车用1标识，e理解成下(down)公交车用-1标识
    # 2. 排序的理解: 如果存在两个人，在同一个时间，一个上，一个下，此时应先下车，再上车，为了
    #    避免先上车，车上在这一时刻的人数比原有的人数多一
    for up, down in nums:
        q.append([up, 1])
        q.append([down, -1])
    q.sort(key=cmp_to_key(cmp))
    cur = 0
    ans = 0
    for _, val in q:
        cur += val
        ans = max(ans, cur)
    print(ans)


while True:
    try:
        n = int(input().strip())
        nums = [list(map(int, input().strip().split())) for _ in range(n)]
        solve(nums)
    except Exception as e:
        break
