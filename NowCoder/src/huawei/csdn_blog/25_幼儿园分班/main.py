import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(nums):
    # 第一个同学
    start = nums[0].split("/")
    A = [start[0]]
    B = []

    stus = [A, B]
    # 从第二个同学开始判断
    for n in nums[1:]:
        id_, f = n.split("/")

        if f == 'N':
            stus = stus[::-1]
        stus[0].append(id_)

    if A:
        print(" ".join(sorted(A, key=lambda x: int(x))))
    if B:
        print(" ".join(sorted(B, key=lambda x: int(x))))


while True:
    try:
        nums = input().strip().split()
        solve(nums)
    except Exception as e:
        break
