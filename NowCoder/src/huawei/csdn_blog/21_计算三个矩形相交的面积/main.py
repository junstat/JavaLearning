import sys

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(rec1, rec2, rec3):
    get_point = lambda rec: (rec[0], rec[1], rec[0] + rec[2], rec[1] - rec[3])
    sx1, sy1, ex1, ey1 = get_point(rec1)
    sx2, sy2, ex2, ey2 = get_point(rec2)
    sx3, sy3, ex3, ey3 = get_point(rec3)
    if sx1 >= ex2 or ex1 < sx2:
        return 0

    left_x = max(sx1, sx2, sx3)
    left_y = min(sy1, sy2, sy3)

    right_x = min(ex1, ex2, ex3)
    right_y = max(ey1, ey2, ey3)
    print((right_x - left_x) * (left_y - right_y))


while True:
    try:
        rec1 = list(map(int, input().strip().split()))
        rec2 = list(map(int, input().strip().split()))
        rec3 = list(map(int, input().strip().split()))
        solve(rec1, rec2, rec3)
    except Exception as e:
        break
