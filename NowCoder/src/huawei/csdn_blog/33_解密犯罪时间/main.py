import datetime
import sys
import time

if sys.platform != "Linux":
    file_in = open("input.txt")
    sys.stdin = file_in


def solve(s):
    today = time.strftime('%Y-%m-%d', time.localtime())
    strs = today + ' ' + s
    pass_time = datetime.datetime.strptime(strs, '%Y-%m-%d %H:%M')

    while True:
        pass_time = pass_time + datetime.timedelta(minutes=1)
        h_m = pass_time.strftime('%H:%M')
        cnt = 0
        for c in h_m:
            if c in s:
                cnt += 1
        if cnt == len(h_m):
            break

    print(h_m)


for line in sys.stdin:
    solve(line.strip())
