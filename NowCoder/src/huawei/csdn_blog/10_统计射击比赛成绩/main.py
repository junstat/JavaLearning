import sys
from collections import defaultdict

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(ids, scores, n):
    map = defaultdict(list)
    for idx, score in zip(ids, scores):
        # print(idx, score)
        map[idx].append(score)

    # print(map)
    order = []
    for idx, s in map.items():
        if len(s) < 3:
            continue
        s.sort()
        order.append([idx, sum(s[:3])])

    order.sort(key=lambda x: (-x[1], -x[0]))
    print(",".join([str(idx) for idx, _ in order]))


while True:
    try:
        n = int(input().strip())
        ids = list(map(int, input().strip().split(",")))
        scores = list(map(int, input().strip().split(",")))
        solve(ids, scores, n)
    except Exception as e:
        break
