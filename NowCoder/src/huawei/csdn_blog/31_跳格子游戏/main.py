import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def dfs(s, link, f):
    """
    用深搜遍历所有节点
    :param s: 起点
    :param link: 已经遍历的节点 (s, e)
    """
    # 所有节点都已开启
    if len(link) == len(nums):
        f.append(1)
        return
    ends = []
    # 遍历本次可以开启的格子
    for start_, end_ in nums:
        if s == start_:
            link.append(1)
            # 可能由一个点开启多个格子
            ends.append(end_)
    # 本次被打开的格子，可以重复上面的操作，打开新的格子
    for end_ in ends:
        dfs(end_, link, f)


def solve(nums, n):
    # 格子开启状态
    # 1 表示格子是开启状态，可以从该点去其他点
    # 0 表示格子是关闭状态，需要其他点来打开
    state = [1 for _ in range(n)]
    for start, end in nums:
        state[end] = 0

    # 没有起始的格子
    if max(state) == 0:
        print("no")
        return
    f = [0]
    # 遍历所有节点
    for i in range(n):
        # 从状态开启的节点，进行递归
        if state[i] == 1:
            dfs(i, [], f)

    if max(f):
        print("yes")
    else:
        print("no")


while True:
    try:
        n = int(input().strip())
        nums = []
        for _ in range(n):
            line = input().split()
            if line and len(line) == 2:
                nums.append(tuple(map(int, line)))
            else:
                break
        solve(nums, n)
    except Exception as e:
        solve(nums, n)
        break
