import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(s):
    # x$y = 3x+y+2
    f1 = lambda x, y: 3 * x + y + 2
    # x#y = 2x+3y+4
    f2 = lambda x, y: 2 * x + 3 * y + 4
    n = len(s)
    nums = []
    ops = []

    i = 0
    while i < n:
        c = s[i]
        if c == "#":
            if ops and ops[-1] == "$":
                ops.pop()
                b = nums.pop()
                a = nums.pop()
                nums.append(f1(a, b))
            ops.append(c)
            i += 1
        elif c == "$":
            ops.append(c)
            i += 1
        else:
            u = 0
            j = i
            while j < n and s[j].isdigit():
                u = u * 10 + int(s[j])
                j += 1
            nums.append(u)
            i = j

    while len(nums) > 1:
        a = nums.pop(0)
        b = nums.pop(0)
        nums.insert(0, f2(a, b))
    print(nums[0])


for line in sys.stdin:
    solve(line.strip())
